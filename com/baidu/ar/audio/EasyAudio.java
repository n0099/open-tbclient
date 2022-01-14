package com.baidu.ar.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class EasyAudio implements IEasyAudio, VolumeListener, a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "EasyAudio";
    public static volatile EasyAudio iV;
    public transient /* synthetic */ FieldHolder $fh;
    public b iQ;
    public ArrayList<EasyAudioCallback> iR;
    public ArrayList<VolumeListener> iS;
    public final Lock iT;
    public final Lock iU;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1616931344, "Lcom/baidu/ar/audio/EasyAudio;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1616931344, "Lcom/baidu/ar/audio/EasyAudio;");
        }
    }

    public EasyAudio() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.iT = new ReentrantLock(true);
        this.iU = new ReentrantLock(true);
    }

    private synchronized void ct() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.iQ != null) {
                    this.iQ.ch();
                    this.iQ.ci();
                    this.iQ = null;
                }
            }
        }
    }

    private synchronized void cu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
                this.iT.lock();
                if (this.iR != null) {
                    this.iR.clear();
                    this.iR = null;
                }
                this.iT.unlock();
                if (this.iS != null) {
                    this.iS.clear();
                    this.iS = null;
                }
                releaseInstance();
            }
        }
    }

    public static EasyAudio getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (iV == null) {
                synchronized (EasyAudio.class) {
                    if (iV == null) {
                        iV = new EasyAudio();
                    }
                }
            }
            return iV;
        }
        return (EasyAudio) invokeV.objValue;
    }

    public static void releaseInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            iV = null;
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.iT.lock();
            try {
                if (this.iR != null) {
                    Iterator<EasyAudioCallback> it = this.iR.iterator();
                    while (it.hasNext()) {
                        it.next().onAudioFrameAvailable(byteBuffer, i2, j2);
                    }
                }
            } finally {
                this.iT.unlock();
            }
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cu();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioSetup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                b bVar = this.iQ;
                if (bVar != null) {
                    bVar.startAudio();
                    return;
                }
                return;
            }
            ArrayList<EasyAudioCallback> arrayList = this.iR;
            if (arrayList == null || arrayList.get(0) == null) {
                return;
            }
            this.iR.get(0).onAudioStart(false, null);
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ArrayList<EasyAudioCallback> arrayList = this.iR;
            if (arrayList != null && arrayList.get(0) != null && this.iQ != null) {
                this.iR.get(0).onAudioStart(z, this.iQ.cj());
            }
            if (z) {
                return;
            }
            release();
        }
    }

    @Override // com.baidu.ar.audio.a
    public void onAudioStop(boolean z) {
        ArrayList<EasyAudioCallback> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (arrayList = this.iR) == null || arrayList.get(0) == null) {
            return;
        }
        this.iR.get(0).onAudioStop(z);
    }

    @Override // com.baidu.ar.audio.VolumeListener
    public void onRealtimeVolume(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.iU.lock();
            try {
                if (this.iS != null) {
                    Iterator<VolumeListener> it = this.iS.iterator();
                    while (it.hasNext()) {
                        it.next().onRealtimeVolume(i2);
                    }
                }
            } finally {
                this.iU.unlock();
            }
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ct();
            cu();
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void removeVolumeListener(VolumeListener volumeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, volumeListener) == null) {
            if (volumeListener == null) {
                com.baidu.ar.h.b.b(TAG, "VolumeListener can not be null!!!");
                return;
            }
            this.iU.lock();
            try {
                if (this.iS != null && this.iS.size() > 0 && this.iS.contains(volumeListener)) {
                    this.iS.remove(volumeListener);
                }
            } finally {
                this.iU.unlock();
            }
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void setVolumeListener(VolumeListener volumeListener) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, volumeListener) == null) {
            if (volumeListener == null) {
                str = TAG;
                str2 = "VolumeListener can not be null!!!";
            } else {
                if (this.iS == null) {
                    this.iS = new ArrayList<>();
                }
                if (!this.iS.contains(volumeListener)) {
                    if (this.iQ == null) {
                        this.iQ = b.cf();
                    }
                    this.iU.lock();
                    try {
                        if (this.iS.size() == 0) {
                            this.iQ.setVolumeListener(this);
                        }
                        this.iS.add(volumeListener);
                        return;
                    } finally {
                        this.iU.unlock();
                    }
                }
                str = TAG;
                str2 = "setVolumeListener volumeListener has been added!!!";
            }
            com.baidu.ar.h.b.b(str, str2);
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, audioParams, easyAudioCallback) == null) {
            if (audioParams == null || easyAudioCallback == null) {
                str = TAG;
                str2 = "AudioParams && EasyAudioCallback can not be null!!!";
            } else {
                if (this.iQ == null) {
                    this.iQ = b.cf();
                }
                if (this.iR == null) {
                    this.iR = new ArrayList<>();
                }
                if (!this.iR.contains(easyAudioCallback)) {
                    if (this.iQ.isRunning()) {
                        easyAudioCallback.onAudioStart(true, this.iQ.cj());
                    } else {
                        this.iR.clear();
                        this.iQ.a(audioParams, this);
                    }
                    this.iT.lock();
                    try {
                        if (this.iR != null) {
                            this.iR.add(easyAudioCallback);
                        }
                        return;
                    } finally {
                        this.iT.unlock();
                    }
                }
                str = TAG;
                str2 = "EasyAudio has been started!!!";
            }
            com.baidu.ar.h.b.b(str, str2);
        }
    }

    @Override // com.baidu.ar.audio.IEasyAudio
    public void stopAudio(EasyAudioCallback easyAudioCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, easyAudioCallback) == null) {
            if (easyAudioCallback == null) {
                com.baidu.ar.h.b.b(TAG, "EasyAudioCallback can not be null!!!");
                return;
            }
            ArrayList<EasyAudioCallback> arrayList = this.iR;
            if (arrayList == null || !arrayList.contains(easyAudioCallback)) {
                com.baidu.ar.h.b.b(TAG, "Please confirm EasyAudio has been started!!!");
            } else if (this.iR.size() <= 1) {
                ct();
            } else {
                this.iT.lock();
                try {
                    boolean remove = this.iR.remove(easyAudioCallback);
                    this.iT.unlock();
                    easyAudioCallback.onAudioStop(remove);
                } catch (Throwable th) {
                    this.iT.unlock();
                    throw th;
                }
            }
        }
    }
}
