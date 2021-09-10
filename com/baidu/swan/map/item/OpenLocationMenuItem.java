package com.baidu.swan.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.p0.a.v2.n0;
import c.a.p0.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class OpenLocationMenuItem {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f47139e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MenuItemType f47140a;

    /* renamed from: b  reason: collision with root package name */
    public b f47141b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47142c;

    /* renamed from: d  reason: collision with root package name */
    public int f47143d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class MenuItemType {
        public static final /* synthetic */ MenuItemType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MenuItemType OPENLOCATION_BAIDU_MAP;
        public static final MenuItemType OPENLOCATION_CANCEL;
        public static final MenuItemType OPENLOCATION_GAODE_MAP;
        public static final MenuItemType OPENLOCATION_GOOGLE_MAP;
        public static final MenuItemType OPENLOCATION_PATH;
        public static final MenuItemType OPENLOCATION_SOUGOU_MAP;
        public static final MenuItemType OPENLOCATION_STREET_VIEW;
        public static final MenuItemType OPENLOCATION_TENCENT_MAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1435556757, "Lcom/baidu/swan/map/item/OpenLocationMenuItem$MenuItemType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1435556757, "Lcom/baidu/swan/map/item/OpenLocationMenuItem$MenuItemType;");
                    return;
                }
            }
            OPENLOCATION_PATH = new MenuItemType("OPENLOCATION_PATH", 0);
            OPENLOCATION_STREET_VIEW = new MenuItemType("OPENLOCATION_STREET_VIEW", 1);
            OPENLOCATION_CANCEL = new MenuItemType("OPENLOCATION_CANCEL", 2);
            OPENLOCATION_BAIDU_MAP = new MenuItemType("OPENLOCATION_BAIDU_MAP", 3);
            OPENLOCATION_GAODE_MAP = new MenuItemType("OPENLOCATION_GAODE_MAP", 4);
            OPENLOCATION_TENCENT_MAP = new MenuItemType("OPENLOCATION_TENCENT_MAP", 5);
            OPENLOCATION_SOUGOU_MAP = new MenuItemType("OPENLOCATION_SOUGOU_MAP", 6);
            MenuItemType menuItemType = new MenuItemType("OPENLOCATION_GOOGLE_MAP", 7);
            OPENLOCATION_GOOGLE_MAP = menuItemType;
            $VALUES = new MenuItemType[]{OPENLOCATION_PATH, OPENLOCATION_STREET_VIEW, OPENLOCATION_CANCEL, OPENLOCATION_BAIDU_MAP, OPENLOCATION_GAODE_MAP, OPENLOCATION_TENCENT_MAP, OPENLOCATION_SOUGOU_MAP, menuItemType};
        }

        public MenuItemType(String str, int i2) {
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

        public static MenuItemType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MenuItemType) Enum.valueOf(MenuItemType.class, str) : (MenuItemType) invokeL.objValue;
        }

        public static MenuItemType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MenuItemType[]) $VALUES.clone() : (MenuItemType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OpenLocationMenuItem f47144e;

        public a(OpenLocationMenuItem openLocationMenuItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {openLocationMenuItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47144e = openLocationMenuItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47144e.f47141b == null) {
                return;
            }
            this.f47144e.f47141b.onMenuItemClick(this.f47144e);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onMenuItemClick(OpenLocationMenuItem openLocationMenuItem);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733358351, "Lcom/baidu/swan/map/item/OpenLocationMenuItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1733358351, "Lcom/baidu/swan/map/item/OpenLocationMenuItem;");
                return;
            }
        }
        f47139e = n0.g(45.0f);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, menuItemType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47142c = new TextView(context);
        this.f47143d = n0.g(1.0f);
        this.f47142c.setText(str);
        this.f47142c.setTextSize(16.0f);
        this.f47142c.setBackground(context.getResources().getDrawable(d.openlocation_bottommenu_itemclick_selector));
        this.f47142c.setTextColor(-16777216);
        this.f47142c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f47139e);
        layoutParams.bottomMargin = this.f47143d;
        layoutParams.gravity = 17;
        this.f47142c.setLayoutParams(layoutParams);
        e(str);
        f(menuItemType);
        this.f47142c.setOnClickListener(new a(this));
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47142c : (TextView) invokeV.objValue;
    }

    public MenuItemType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47140a : (MenuItemType) invokeV.objValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f47141b = bVar;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void f(MenuItemType menuItemType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, menuItemType) == null) {
            this.f47140a = menuItemType;
        }
    }
}
