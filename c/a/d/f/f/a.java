package c.a.d.f.f;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.f.b;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_CRASHTIME_LIMIT = 10;
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDefaultType;
    public String[] mKey;
    public int mMaxCrashTimes;
    public String mName;
    public int mOffType;
    public b.a mSwitchListener;

    /* renamed from: c.a.d.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0044a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0044a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d.f.f.b.a
        public void a(String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.changeSettingByType(i2);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultType = 0;
        this.mOffType = 1;
        this.mMaxCrashTimes = 10;
        this.mSwitchListener = new C0044a(this);
        initData();
        addToManager();
    }

    public void addToManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b(this.mName, this.mDefaultType, this.mSwitchListener);
            bVar.i(this.mMaxCrashTimes, this.mKey, this.mOffType);
            bVar.k(getSwitchLibs());
            SwitchManager.getInstance().addSwitchData(bVar);
        }
    }

    public abstract void changeSettingByType(int i2);

    public abstract String[] getCrashKeys();

    public abstract int getDefaultType();

    public abstract int getMaxCrashTimes();

    public abstract String getName();

    public abstract int getOffType();

    public String[] getSwitchLibs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mName = getName();
            this.mKey = getCrashKeys();
            this.mDefaultType = getDefaultType();
            this.mOffType = getOffType();
            this.mMaxCrashTimes = getMaxCrashTimes();
        }
    }
}
