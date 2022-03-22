package c.a.p0.f0.a;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f0.a.a;
import c.a.p0.q4.n.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements c.a.p0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.q4.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13819b;

    /* renamed from: c  reason: collision with root package name */
    public a.c f13820c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f13821d;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC1048a f13822e;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC1343a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.q4.n.a.InterfaceC1343a
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.f13821d != null) {
                    return this.a.f13821d.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // c.a.p0.q4.n.a.InterfaceC1343a
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (this.a.f13822e != null) {
                    this.a.f13822e.a(f2);
                }
                TextView textView = this.a.f13819b;
                b bVar = this.a;
                textView.setText(bVar.h(bVar.getProgress()));
            }
        }

        @Override // c.a.p0.q4.n.a.InterfaceC1343a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f13820c == null) {
                return;
            }
            this.a.f13820c.a();
        }

        @Override // c.a.p0.q4.n.a.InterfaceC1343a
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.a.f13819b.setText(this.a.h(f2));
            }
        }
    }

    public b(c.a.p0.q4.n.a aVar, TextView textView, a.c cVar, a.b bVar, a.InterfaceC1048a interfaceC1048a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, textView, cVar, bVar, interfaceC1048a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f13819b = textView;
        this.f13820c = cVar;
        this.f13821d = bVar;
        this.f13822e = interfaceC1048a;
        i();
    }

    @Override // c.a.p0.f0.a.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                return aVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                return aVar.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f0.a.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                return aVar.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // c.a.p0.f0.a.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                return aVar.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String h(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
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

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar == null) {
                return false;
            }
            aVar.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean setMaxDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.setMaxDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean setMinDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.setMinDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.p0.f0.a.a
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.p0.q4.n.a aVar = this.a;
            if (aVar != null) {
                aVar.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
