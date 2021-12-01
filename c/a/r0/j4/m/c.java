package c.a.r0.j4.m;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j4.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f18420e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f18421f;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18422b;

    /* renamed from: c  reason: collision with root package name */
    public b f18423c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f18424d;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.f18423c != null) {
                    this.a.f18423c.a(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-84099116, "Lc/a/r0/j4/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-84099116, "Lc/a/r0/j4/m/c;");
                return;
            }
        }
        f18420e = e.icon_mask_video_bulleton52;
        f18421f = e.icon_mask_video_bulletoff52;
    }

    public c(View view, @IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18424d = new a(this, 2921647);
        MessageManager.getInstance().registerListener(this.f18424d);
        this.a = view;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(i2);
            this.f18422b = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        j(d());
    }

    public static StatisticItem b(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i2)) == null) ? new StatisticItem(str).param("obj_locate", c(i2)).param("tid", str2).param("uid", TbadkCoreApplication.getCurrentAccountId()) : (StatisticItem) invokeLLI.objValue;
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? (i2 == 4 || i2 == 3) ? "2" : "1" : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbSingleton.getInstance().isDanmuSwitchOpen() : invokeV.booleanValue;
    }

    public void e(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            TiebaStatic.log(b("c14474", str, i2).param("obj_type", d() ? "1" : "0"));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f18424d);
            ImageView imageView = this.f18422b;
            if (imageView != null) {
                imageView.setOnClickListener(null);
            }
            this.f18423c = null;
        }
    }

    public void g(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (imageView = this.f18422b) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f18423c = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = !d();
            TbSingleton.getInstance().setDanmuSwitchOpen(z);
            j(z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921647, Boolean.valueOf(z)));
        }
    }

    public void j(boolean z) {
        ImageView imageView;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.f18422b) == null || (view = this.a) == null) {
            return;
        }
        imageView.setImageDrawable(view.getResources().getDrawable(z ? f18420e : f18421f));
    }
}
