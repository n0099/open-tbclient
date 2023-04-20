package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e75;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class MyAudioRecorder implements e75 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] n;
    public static Object o;
    public static AudioRecord p;
    public static MediaRecorder q;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread a;
    public boolean b;
    public int c;
    public String d;
    public State e;
    public RandomAccessFile f;
    public short g;
    public int h;
    public short i;
    public int j;
    public int k;
    public byte[] l;
    public int m;

    public final short g(byte b, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Byte.valueOf(b), Byte.valueOf(b2)})) == null) ? (short) (b | (b2 << 8)) : invokeCommon.shortValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State ERROR;
        public static final State INITIALIZING;
        public static final State READY;
        public static final State RECORDING;
        public static final State STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1848254934, "Lcom/baidu/tbadk/core/voice/service/MyAudioRecorder$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1848254934, "Lcom/baidu/tbadk/core/voice/service/MyAudioRecorder$State;");
                    return;
                }
            }
            INITIALIZING = new State("INITIALIZING", 0);
            READY = new State("READY", 1);
            RECORDING = new State("RECORDING", 2);
            ERROR = new State("ERROR", 3);
            State state = new State("STOPPED", 4);
            STOPPED = state;
            $VALUES = new State[]{INITIALIZING, READY, RECORDING, ERROR, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyAudioRecorder a;

        public a(MyAudioRecorder myAudioRecorder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myAudioRecorder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myAudioRecorder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.n();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(786650199, "Lcom/baidu/tbadk/core/voice/service/MyAudioRecorder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(786650199, "Lcom/baidu/tbadk/core/voice/service/MyAudioRecorder;");
                return;
            }
        }
        n = new int[]{44100, 22050, 11025, 8000};
        o = new Object();
        p = null;
        q = null;
    }

    @Override // com.baidu.tieba.e75
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (o) {
                if (this.a == null || !this.a.isAlive()) {
                    Thread thread = new Thread(new a(this));
                    this.a = thread;
                    thread.start();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public MyAudioRecorder(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = null;
        try {
            this.b = z;
            if (z) {
                if (i4 == 2) {
                    this.i = (short) 16;
                } else {
                    this.i = (short) 8;
                }
                if (i3 == 2) {
                    this.g = (short) 1;
                } else {
                    this.g = (short) 2;
                }
                this.h = i2;
                int i7 = (i2 * 120) / 1000;
                this.k = i7;
                int i8 = (((i7 * 2) * this.i) * this.g) / 8;
                this.j = i8;
                if (i8 < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.i * 2) * this.g) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.j));
                }
                AudioRecord audioRecord = new AudioRecord(i, i2, i3, i4, this.j);
                p = audioRecord;
                if (audioRecord.getRecordingState() == 3) {
                    p.stop();
                }
                if (p.getState() != 1) {
                    throw new Exception("AudioRecord initialization failed");
                }
            } else {
                MediaRecorder mediaRecorder = new MediaRecorder();
                q = mediaRecorder;
                mediaRecorder.setAudioSource(1);
                q.setOutputFormat(1);
                q.setAudioEncoder(1);
            }
            this.c = 0;
            this.d = null;
            this.e = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                BdLog.e(e);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.e = State.ERROR;
        }
    }

    @Override // com.baidu.tieba.e75
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (k(str)) {
                return i();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static MyAudioRecorder f(Boolean bool) {
        InterceptResult invokeL;
        MyAudioRecorder myAudioRecorder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bool)) == null) {
            synchronized (o) {
                p = null;
                q = null;
                int i = 3;
                if (bool.booleanValue()) {
                    myAudioRecorder = new MyAudioRecorder(false, 1, n[3], 2, 2);
                } else {
                    do {
                        myAudioRecorder = new MyAudioRecorder(true, 1, n[i], 2, 2);
                        i--;
                        if (i < 0) {
                            break;
                        }
                    } while (myAudioRecorder.h() != State.INITIALIZING);
                }
            }
            return myAudioRecorder;
        }
        return (MyAudioRecorder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.e75
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = State.STOPPED;
        }
    }

    @Override // com.baidu.tieba.e75
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.e == State.RECORDING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public State h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (State) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                if (this.e == State.INITIALIZING) {
                    if (this.b) {
                        if (p.getState() == 1 && this.d != null) {
                            if (this.f != null) {
                                this.f.close();
                                this.f = null;
                            }
                            RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
                            this.f = randomAccessFile;
                            randomAccessFile.setLength(0L);
                            this.f.writeBytes("RIFF");
                            this.f.writeInt(0);
                            this.f.writeBytes("WAVE");
                            this.f.writeBytes("fmt ");
                            this.f.writeInt(Integer.reverseBytes(16));
                            this.f.writeShort(Short.reverseBytes((short) 1));
                            this.f.writeShort(Short.reverseBytes(this.g));
                            this.f.writeInt(Integer.reverseBytes(this.h));
                            this.f.writeInt(Integer.reverseBytes(((this.h * this.i) * this.g) / 8));
                            this.f.writeShort(Short.reverseBytes((short) ((this.g * this.i) / 8)));
                            this.f.writeShort(Short.reverseBytes(this.i));
                            this.f.writeBytes("data");
                            this.f.writeInt(0);
                            this.l = new byte[((this.k * this.i) / 8) * this.g];
                            this.e = State.READY;
                        } else {
                            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                            this.e = State.ERROR;
                            return false;
                        }
                    } else {
                        q.prepare();
                        this.e = State.READY;
                    }
                    return true;
                }
                BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
                j();
                this.e = State.ERROR;
                return false;
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
                } else {
                    BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
                }
                this.e = State.ERROR;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            State state = this.e;
            if (state == State.RECORDING) {
                m();
            } else if (state == State.READY && this.b) {
                try {
                    this.f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.d).delete();
            }
            if (this.b) {
                AudioRecord audioRecord = p;
                if (audioRecord != null) {
                    audioRecord.release();
                    return;
                }
                return;
            }
            MediaRecorder mediaRecorder = q;
            if (mediaRecorder != null) {
                mediaRecorder.release();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.e == State.READY) {
                if (this.b) {
                    this.m = 0;
                    p.startRecording();
                    AudioRecord audioRecord = p;
                    byte[] bArr = this.l;
                    audioRecord.read(bArr, 0, bArr.length);
                } else {
                    q.start();
                }
                this.e = State.RECORDING;
                return;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
            this.e = State.ERROR;
        }
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                if (this.e == State.INITIALIZING) {
                    this.d = str;
                    if (!this.b) {
                        q.setOutputFile(str);
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    BdLog.e(MyAudioRecorder.class.getName() + e.getMessage());
                } else {
                    BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
                }
                this.e = State.ERROR;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
            p.stop();
            try {
                this.f.seek(4L);
                this.f.writeInt(Integer.reverseBytes(this.m + 36));
                this.f.seek(40L);
                this.f.writeInt(Integer.reverseBytes(this.m));
                this.f.close();
                BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
            } catch (IOException unused) {
                BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                this.e = State.ERROR;
            }
            this.e = State.STOPPED;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || p == null) {
            return;
        }
        try {
            l();
            while (c()) {
                int i = 0;
                p.read(this.l, 0, this.l.length);
                try {
                    System.out.println(this.l);
                    this.f.write(this.l);
                    this.m += this.l.length;
                    if (this.i == 16) {
                        while (i < this.l.length / 2) {
                            int i2 = i * 2;
                            short g = g(this.l[i2], this.l[i2 + 1]);
                            if (g > this.c) {
                                this.c = g;
                            }
                            i++;
                        }
                    } else {
                        while (i < this.l.length) {
                            if (this.l[i] > this.c) {
                                this.c = this.l[i];
                            }
                            i++;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            m();
            j();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
