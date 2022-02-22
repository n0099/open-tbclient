package c.a.h.a.a;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import c.a.d.f.p.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.audiorecorder.lib.voice.BdSoundGate;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f3709e;

    /* renamed from: f  reason: collision with root package name */
    public String f3710f;

    /* renamed from: g  reason: collision with root package name */
    public int f3711g;

    /* renamed from: h  reason: collision with root package name */
    public FileOutputStream f3712h;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f3713i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f3714j;
    public long k;
    public long l;
    public final Handler m;
    public final Runnable n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3715e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3715e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3715e.g((int) (System.currentTimeMillis() - this.f3715e.k));
                this.f3715e.m.postDelayed(this.f3715e.n, 200L);
            }
        }
    }

    public b(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3709e = 0;
        this.m = new Handler();
        this.n = new a(this);
        this.f3714j = handler;
        try {
            Amrnb amrnb = Amrnb.getInstance();
            this.f3713i = amrnb;
            if (amrnb == null || !Amrnb.bLoadLibrary) {
                this.f3713i = null;
                if (this.f3714j != null) {
                    this.f3714j.sendMessage(this.f3714j.obtainMessage(5));
                }
            }
        } catch (Exception unused) {
            Handler handler2 = this.f3714j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(5));
            }
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f3709e = 5;
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FileOutputStream fileOutputStream = this.f3712h;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f(short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sArr) == null) {
            byte[] bArr = new byte[32];
            try {
                this.f3712h.write(bArr, 0, this.f3713i.encoderEncode(2, sArr, bArr));
            } catch (IOException unused) {
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Message obtainMessage = this.f3714j.obtainMessage(9);
            obtainMessage.arg1 = i2;
            this.f3714j.sendMessage(obtainMessage);
        }
    }

    public final void h(List<short[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            int a2 = BdSoundGate.b().a();
            short[] sArr = new short[a2];
            short[] sArr2 = new short[a2];
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                System.arraycopy(list.get(i3), 0, sArr2, i2, 160);
                i2 += 160;
                if (i3 == size - 1) {
                    BdSoundGate.b().f(sArr2, sArr);
                    int i4 = 0;
                    for (int i5 = 0; i5 < size; i5++) {
                        System.arraycopy(sArr, i4, list.get(i5), 0, 160);
                        i4 += 160;
                        f(list.get(i5));
                    }
                    i2 = 0;
                }
            }
        }
    }

    public boolean i(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (this.f3713i == null) {
                return false;
            }
            this.f3709e = 0;
            this.f3710f = str;
            this.f3711g = i2;
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f3709e = 4;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        Process.setThreadPriority(-19);
        if (this.f3713i == null) {
            Handler handler2 = this.f3714j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(5));
            }
        } else if (this.f3709e == 4) {
            Handler handler3 = this.f3714j;
            if (handler3 != null) {
                handler3.sendMessage(handler3.obtainMessage(8));
            }
            this.f3709e = 0;
        } else {
            String str = this.f3710f;
            AudioRecord audioRecord2 = null;
            boolean z = true;
            if (str != null && str.length() > 0) {
                try {
                    File h2 = h.h(null, this.f3710f);
                    if (h2 != null) {
                        this.f3712h = new FileOutputStream(h2);
                    } else if (this.f3714j != null) {
                        this.f3714j.sendMessage(this.f3714j.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    e();
                    Handler handler4 = this.f3714j;
                    if (handler4 != null) {
                        handler4.sendMessage(handler4.obtainMessage(1));
                    }
                    this.f3709e = 0;
                    return;
                }
            }
            if (this.f3709e == 4) {
                Handler handler5 = this.f3714j;
                if (handler5 != null) {
                    handler5.sendMessage(handler5.obtainMessage(8));
                }
                e();
                this.f3709e = 0;
                return;
            }
            try {
                audioRecord = c.b().a();
            } catch (IllegalArgumentException unused) {
                Handler handler6 = this.f3714j;
                if (handler6 != null) {
                    handler6.sendMessage(handler6.obtainMessage(6));
                }
                e();
                this.f3709e = 0;
                return;
            } catch (Exception unused2) {
                audioRecord = null;
            }
            if (audioRecord != null && audioRecord.getState() != 0) {
                if (this.f3709e == 4) {
                    try {
                        audioRecord.release();
                    } catch (Exception unused3) {
                    }
                    Handler handler7 = this.f3714j;
                    if (handler7 != null) {
                        handler7.sendMessage(handler7.obtainMessage(8));
                    }
                    e();
                    this.f3709e = 0;
                    return;
                }
                audioRecord.startRecording();
                if (this.f3709e == 4) {
                    try {
                        audioRecord.stop();
                        audioRecord.release();
                    } catch (Exception unused4) {
                    }
                    Handler handler8 = this.f3714j;
                    if (handler8 != null) {
                        handler8.sendMessage(handler8.obtainMessage(8));
                    }
                    e();
                    this.f3709e = 0;
                    return;
                }
                this.f3709e = 3;
                try {
                    if (this.f3712h == null) {
                        try {
                            audioRecord.stop();
                            audioRecord.release();
                        } catch (Exception unused5) {
                            audioRecord2 = audioRecord;
                        }
                        try {
                            if (this.f3714j != null) {
                                this.f3714j.sendMessage(this.f3714j.obtainMessage(1));
                            }
                            this.f3709e = 0;
                            return;
                        } catch (IOException unused6) {
                            audioRecord = audioRecord2;
                            try {
                                audioRecord.stop();
                                audioRecord.release();
                            } catch (Exception unused7) {
                            }
                            Handler handler9 = this.f3714j;
                            if (handler9 != null) {
                                handler9.sendMessage(handler9.obtainMessage(3));
                            }
                            this.f3709e = 0;
                            return;
                        }
                    }
                    h.D(this.f3712h);
                    this.f3713i.encoderInit();
                    if (this.f3711g > 0) {
                        BdSoundGate.b().d(FeatureCodes.ADVANCE_BEAUTY, this.f3711g);
                    }
                    ArrayList arrayList = new ArrayList();
                    this.k = System.currentTimeMillis();
                    this.m.post(this.n);
                    short[] sArr = null;
                    short s = 0;
                    while (true) {
                        if (this.f3709e != 3) {
                            z = false;
                            break;
                        }
                        if (sArr == null) {
                            sArr = new short[160];
                            s = 0;
                        }
                        int read = audioRecord.read(sArr, s, 160 - s);
                        if (read > 0) {
                            int i2 = 0;
                            for (int i3 = 0; i3 < sArr.length; i3++) {
                                i2 += sArr[i3] * sArr[i3];
                            }
                            Handler handler10 = this.f3714j;
                            if (handler10 != null) {
                                Message obtainMessage = handler10.obtainMessage(4);
                                int abs = Math.abs((((int) (i2 / read)) / 100000) >> 1);
                                while (abs > 100) {
                                    abs = (int) (abs / 10.0d);
                                }
                                obtainMessage.arg1 = abs;
                                this.f3714j.sendMessage(obtainMessage);
                            }
                        }
                        s = (short) (s + read);
                        if (s == 160) {
                            if (this.f3711g > 0) {
                                int size = arrayList.size() + 1;
                                if (size > 1 && size % 10 == 0) {
                                    h(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr);
                            } else {
                                f(sArr);
                            }
                            sArr = null;
                        }
                        ArrayList arrayList2 = arrayList;
                        if (System.currentTimeMillis() - this.k > c.a.d.f.q.d.a) {
                            break;
                        }
                        arrayList = arrayList2;
                    }
                    System.currentTimeMillis();
                    if (sArr != null) {
                        while (s < 160) {
                            try {
                                if (s >= sArr.length || s < 0) {
                                    break;
                                }
                                sArr[s] = 0;
                                s = (short) (s + 1);
                            } catch (Exception unused8) {
                            }
                        }
                        f(sArr);
                    }
                    if (this.f3711g > 0) {
                        BdSoundGate.b().e();
                    }
                    System.currentTimeMillis();
                    audioRecord.stop();
                    audioRecord.release();
                    System.currentTimeMillis();
                    if (this.f3709e == 5) {
                        if (!e()) {
                            Handler handler11 = this.f3714j;
                            if (handler11 != null) {
                                handler11.sendMessage(handler11.obtainMessage(2));
                            }
                        } else {
                            try {
                                h.k(this.f3710f);
                                if (this.f3714j != null) {
                                    this.f3714j.sendMessage(this.f3714j.obtainMessage(100));
                                }
                            } catch (Exception unused9) {
                                Handler handler12 = this.f3714j;
                                if (handler12 != null) {
                                    handler12.sendMessage(handler12.obtainMessage(101));
                                }
                                this.f3709e = 0;
                            }
                        }
                        this.f3709e = 0;
                        return;
                    }
                    this.f3709e = 4;
                    long currentTimeMillis = System.currentTimeMillis() - this.k;
                    this.l = currentTimeMillis;
                    g((int) currentTimeMillis);
                    Handler handler13 = this.m;
                    if (handler13 != null) {
                        handler13.removeCallbacks(this.n);
                    }
                    System.currentTimeMillis();
                    if (!e() && (handler = this.f3714j) != null) {
                        handler.sendMessage(handler.obtainMessage(2));
                    }
                    this.f3713i.encoderDeinit();
                    this.f3709e = 0;
                    Handler handler14 = this.f3714j;
                    if (handler14 != null) {
                        if (z) {
                            handler14.sendMessage(handler14.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = handler14.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.l;
                        this.f3714j.sendMessage(obtainMessage2);
                    }
                } catch (IOException unused10) {
                }
            } else {
                if (audioRecord != null) {
                    try {
                        audioRecord.release();
                    } catch (Exception unused11) {
                    }
                }
                Handler handler15 = this.f3714j;
                if (handler15 != null) {
                    handler15.sendMessage(handler15.obtainMessage(6));
                }
                e();
                this.f3709e = 0;
            }
        }
    }
}
