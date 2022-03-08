package c.a.q0.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class w implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f11917e;

    /* renamed from: f  reason: collision with root package name */
    public b f11918f;

    /* renamed from: g  reason: collision with root package name */
    public SensorManager f11919g;

    /* renamed from: h  reason: collision with root package name */
    public Sensor f11920h;

    /* renamed from: i  reason: collision with root package name */
    public Vibrator f11921i;

    /* renamed from: j  reason: collision with root package name */
    public SoundPool f11922j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public MediaPlayer o;
    public double p;
    public double q;

    /* loaded from: classes2.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f11923e;

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11923e = wVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f11923e.o.start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public w(@NonNull Context context, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 2.5d;
        this.q = 4.2d;
        if (context == null) {
            return;
        }
        this.f11917e = context;
        this.f11918f = bVar;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f11919g = sensorManager;
        if (sensorManager != null) {
            this.f11920h = TbadkCoreApplication.getInst().getDefaultSensor(1);
        }
        this.f11921i = (Vibrator) context.getSystemService("vibrator");
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.f11922j = soundPool;
        if (soundPool != null) {
            try {
                this.k = soundPool.load(context, R.raw.shake_tone, 1);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.m > 2000) {
                this.m = currentTimeMillis;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sensorManager = this.f11919g) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.n = false;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final boolean e(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fArr)) == null) {
            double sqrt = Math.sqrt(Math.pow(Math.abs(fArr[0]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[1]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[2]) / 9.8d, 2.0d));
            if (Build.VERSION.SDK_INT <= 23) {
                if (sqrt >= this.p && b()) {
                    return true;
                }
            } else if (sqrt >= this.q && b()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (sensor = this.f11920h) == null) {
            return;
        }
        this.f11919g.registerListener(this, sensor, 2);
        this.n = true;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.f11917e;
            if (context == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int ringerMode = audioManager != null ? audioManager.getRingerMode() : -1;
            Vibrator vibrator = this.f11921i;
            if (vibrator == null || !vibrator.hasVibrator() || ringerMode <= 0) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11921i.vibrate(VibrationEffect.createOneShot(400L, 255));
                return true;
            }
            this.f11921i.vibrate(400L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z && (i2 = this.l) != 0) {
                SoundPool soundPool = this.f11922j;
                if (soundPool != null) {
                    soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                    return;
                }
                return;
            }
            SoundPool soundPool2 = this.f11922j;
            if (soundPool2 != null) {
                soundPool2.play(this.k, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.o == null) {
                this.o = new MediaPlayer();
            }
            try {
                this.o.reset();
                this.o.setLooping(false);
                this.o.setDataSource(str);
                this.o.prepareAsync();
                this.o.setOnPreparedListener(new a(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.q = d2;
        }
    }

    public void k(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.p = d2;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && (bVar = this.f11918f) != null) {
            bVar.a();
        }
    }
}
