package com.baidu.tbadk.core.voice.service;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.h0.c.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.audio.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public class MyAudioRecorder implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] n;
    public static Object o;
    public static AudioRecord p;
    public static MediaRecorder q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f45655a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45656b;

    /* renamed from: c  reason: collision with root package name */
    public int f45657c;

    /* renamed from: d  reason: collision with root package name */
    public String f45658d;

    /* renamed from: e  reason: collision with root package name */
    public State f45659e;

    /* renamed from: f  reason: collision with root package name */
    public RandomAccessFile f45660f;

    /* renamed from: g  reason: collision with root package name */
    public short f45661g;

    /* renamed from: h  reason: collision with root package name */
    public int f45662h;

    /* renamed from: i  reason: collision with root package name */
    public short f45663i;
    public int j;
    public int k;
    public byte[] l;
    public int m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyAudioRecorder f45664e;

        public a(MyAudioRecorder myAudioRecorder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myAudioRecorder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45664e = myAudioRecorder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45664e.n();
            }
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

    public MyAudioRecorder(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45657c = 0;
        this.f45658d = null;
        try {
            this.f45656b = z;
            if (z) {
                if (i5 == 2) {
                    this.f45663i = (short) 16;
                } else {
                    this.f45663i = (short) 8;
                }
                if (i4 == 2) {
                    this.f45661g = (short) 1;
                } else {
                    this.f45661g = (short) 2;
                }
                this.f45662h = i3;
                int i8 = (i3 * 120) / 1000;
                this.k = i8;
                int i9 = (((i8 * 2) * this.f45663i) * this.f45661g) / 8;
                this.j = i9;
                if (i9 < AudioRecord.getMinBufferSize(i3, i4, i5)) {
                    int minBufferSize = AudioRecord.getMinBufferSize(i3, i4, i5);
                    this.j = minBufferSize;
                    this.k = minBufferSize / (((this.f45663i * 2) * this.f45661g) / 8);
                    BdLog.w(MyAudioRecorder.class.getName() + "Increasing buffer size to " + Integer.toString(this.j));
                }
                AudioRecord audioRecord = new AudioRecord(i2, i3, i4, i5, this.j);
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
            this.f45657c = 0;
            this.f45658d = null;
            this.f45659e = State.INITIALIZING;
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                BdLog.e(e2);
            } else {
                BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while initializing recording");
            }
            this.f45659e = State.ERROR;
        }
    }

    public static MyAudioRecorder f(Boolean bool) {
        InterceptResult invokeL;
        MyAudioRecorder myAudioRecorder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bool)) == null) {
            synchronized (o) {
                p = null;
                q = null;
                int i2 = 3;
                if (bool.booleanValue()) {
                    myAudioRecorder = new MyAudioRecorder(false, 1, n[3], 2, 2);
                } else {
                    do {
                        myAudioRecorder = new MyAudioRecorder(true, 1, n[i2], 2, 2);
                        i2--;
                        if (i2 < 0) {
                            break;
                        }
                    } while (myAudioRecorder.h() != State.INITIALIZING);
                }
            }
            return myAudioRecorder;
        }
        return (MyAudioRecorder) invokeL.objValue;
    }

    @Override // b.a.q0.s.h0.c.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f45659e = State.STOPPED;
        }
    }

    @Override // b.a.q0.s.h0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45659e == State.RECORDING : invokeV.booleanValue;
    }

    @Override // b.a.q0.s.h0.c.d
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

    @Override // b.a.q0.s.h0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (o) {
                if (this.f45655a == null || !this.f45655a.isAlive()) {
                    Thread thread = new Thread(new a(this));
                    this.f45655a = thread;
                    thread.start();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final short g(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? (short) (b2 | (b3 << 8)) : invokeCommon.shortValue;
    }

    public State h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45659e : (State) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                if (this.f45659e == State.INITIALIZING) {
                    if (this.f45656b) {
                        if (p.getState() == 1 && this.f45658d != null) {
                            if (this.f45660f != null) {
                                this.f45660f.close();
                                this.f45660f = null;
                            }
                            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f45658d, "rw");
                            this.f45660f = randomAccessFile;
                            randomAccessFile.setLength(0L);
                            this.f45660f.writeBytes(b.f57308e);
                            this.f45660f.writeInt(0);
                            this.f45660f.writeBytes(b.f57309f);
                            this.f45660f.writeBytes(b.f57310g);
                            this.f45660f.writeInt(Integer.reverseBytes(16));
                            this.f45660f.writeShort(Short.reverseBytes((short) 1));
                            this.f45660f.writeShort(Short.reverseBytes(this.f45661g));
                            this.f45660f.writeInt(Integer.reverseBytes(this.f45662h));
                            this.f45660f.writeInt(Integer.reverseBytes(((this.f45662h * this.f45663i) * this.f45661g) / 8));
                            this.f45660f.writeShort(Short.reverseBytes((short) ((this.f45661g * this.f45663i) / 8)));
                            this.f45660f.writeShort(Short.reverseBytes(this.f45663i));
                            this.f45660f.writeBytes("data");
                            this.f45660f.writeInt(0);
                            this.l = new byte[((this.k * this.f45663i) / 8) * this.f45661g];
                            this.f45659e = State.READY;
                        } else {
                            BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on uninitialized recorder");
                            this.f45659e = State.ERROR;
                            return false;
                        }
                    } else {
                        q.prepare();
                        this.f45659e = State.READY;
                    }
                    return true;
                }
                BdLog.e(MyAudioRecorder.class.getName() + "prepare() method called on illegal state");
                j();
                this.f45659e = State.ERROR;
                return false;
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
                } else {
                    BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured in prepare()");
                }
                this.f45659e = State.ERROR;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            State state = this.f45659e;
            if (state == State.RECORDING) {
                m();
            } else if (state == State.READY && this.f45656b) {
                try {
                    this.f45660f.close();
                } catch (IOException unused) {
                    BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                }
                new File(this.f45658d).delete();
            }
            if (this.f45656b) {
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

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                if (this.f45659e == State.INITIALIZING) {
                    this.f45658d = str;
                    if (this.f45656b) {
                        return true;
                    }
                    q.setOutputFile(str);
                    return true;
                }
                return true;
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    BdLog.e(MyAudioRecorder.class.getName() + e2.getMessage());
                } else {
                    BdLog.e(MyAudioRecorder.class.getName() + "Unknown error occured while setting output path");
                }
                this.f45659e = State.ERROR;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f45659e == State.READY) {
                if (this.f45656b) {
                    this.m = 0;
                    p.startRecording();
                    AudioRecord audioRecord = p;
                    byte[] bArr = this.l;
                    audioRecord.read(bArr, 0, bArr.length);
                } else {
                    q.start();
                }
                this.f45659e = State.RECORDING;
                return;
            }
            BdLog.e(MyAudioRecorder.class.getName() + "start() called on illegal state");
            this.f45659e = State.ERROR;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BdLog.e(MyAudioRecorder.class.getName() + "audioRecorder.stop()");
            p.stop();
            try {
                this.f45660f.seek(4L);
                this.f45660f.writeInt(Integer.reverseBytes(this.m + 36));
                this.f45660f.seek(40L);
                this.f45660f.writeInt(Integer.reverseBytes(this.m));
                this.f45660f.close();
                BdLog.e(MyAudioRecorder.class.getName() + "randomAccessWriter.close()");
            } catch (IOException unused) {
                BdLog.e(MyAudioRecorder.class.getName() + "I/O exception occured while closing output file");
                this.f45659e = State.ERROR;
            }
            this.f45659e = State.STOPPED;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || p == null) {
            return;
        }
        try {
            l();
            while (c()) {
                int i2 = 0;
                p.read(this.l, 0, this.l.length);
                try {
                    System.out.println(this.l);
                    this.f45660f.write(this.l);
                    this.m += this.l.length;
                    if (this.f45663i == 16) {
                        while (i2 < this.l.length / 2) {
                            int i3 = i2 * 2;
                            short g2 = g(this.l[i3], this.l[i3 + 1]);
                            if (g2 > this.f45657c) {
                                this.f45657c = g2;
                            }
                            i2++;
                        }
                    } else {
                        while (i2 < this.l.length) {
                            if (this.l[i2] > this.f45657c) {
                                this.f45657c = this.l[i2];
                            }
                            i2++;
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
