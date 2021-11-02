package b.a.r0.z.a;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.c4.l.a;
import b.a.r0.z.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements b.a.r0.z.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.c4.l.a f27810a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27811b;

    /* renamed from: c  reason: collision with root package name */
    public a.c f27812c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f27813d;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC1358a f27814e;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0783a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27815a;

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
            this.f27815a = bVar;
        }

        @Override // b.a.r0.c4.l.a.InterfaceC0783a
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f27815a.f27813d != null) {
                    return this.f27815a.f27813d.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // b.a.r0.c4.l.a.InterfaceC0783a
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (this.f27815a.f27814e != null) {
                    this.f27815a.f27814e.a(f2);
                }
                TextView textView = this.f27815a.f27811b;
                b bVar = this.f27815a;
                textView.setText(bVar.f(bVar.getProgress()));
            }
        }

        @Override // b.a.r0.c4.l.a.InterfaceC0783a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27815a.f27812c == null) {
                return;
            }
            this.f27815a.f27812c.a();
        }

        @Override // b.a.r0.c4.l.a.InterfaceC0783a
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.f27815a.f27811b.setText(this.f27815a.f(f2));
            }
        }
    }

    public b(b.a.r0.c4.l.a aVar, TextView textView, a.c cVar, a.b bVar, a.InterfaceC1358a interfaceC1358a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, textView, cVar, bVar, interfaceC1358a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27810a = aVar;
        this.f27811b = textView;
        this.f27812c = cVar;
        this.f27813d = bVar;
        this.f27814e = interfaceC1358a;
        g();
    }

    @Override // b.a.r0.z.a.a
    public boolean deleteLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.deleteLast();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String f(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            if (f2 >= getMaxDuration()) {
                f2 = getMaxDuration();
            }
            if (f2 > 60.0f) {
                return ((int) (f2 / 60.0f)) + "'" + String.format("%.1f", Float.valueOf(f2 % 60.0f));
            }
            return String.format("%.1f", Float.valueOf(f2));
        }
        return (String) invokeF.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar == null) {
                return false;
            }
            aVar.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                return aVar.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.z.a.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                return aVar.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // b.a.r0.z.a.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                return aVar.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean isShowingDeleteLastTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                return aVar.isShowingDeleteLastTip();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean setMaxDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.setMaxDuration(i2);
                this.f27810a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean setMinDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.setMinDuration(i2);
                this.f27810a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // b.a.r0.z.a.a
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b.a.r0.c4.l.a aVar = this.f27810a;
            if (aVar != null) {
                aVar.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
