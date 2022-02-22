package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class NoDataViewFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ImgType {
        public static final /* synthetic */ ImgType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImgType ANTI;
        public static final ImgType COLLECTION;
        public static final ImgType CREATE;
        public static final ImgType EMOTION;
        public static final ImgType FINDBAR;
        public static final ImgType GIFT;
        public static final ImgType LOCAL;
        public static final ImgType NETERROR;
        public static final ImgType NODATA;
        public static final ImgType NONE;
        public static final ImgType SINGALL;
        public static final ImgType WEBVIEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-148886139, "Lcom/baidu/tbadk/core/view/NoDataViewFactory$ImgType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-148886139, "Lcom/baidu/tbadk/core/view/NoDataViewFactory$ImgType;");
                    return;
                }
            }
            NONE = new ImgType(PolyActivity.NONE_PANEL_TYPE, 0);
            CREATE = new ImgType("CREATE", 1);
            NODATA = new ImgType("NODATA", 2);
            FINDBAR = new ImgType("FINDBAR", 3);
            COLLECTION = new ImgType("COLLECTION", 4);
            EMOTION = new ImgType("EMOTION", 5);
            SINGALL = new ImgType("SINGALL", 6);
            GIFT = new ImgType("GIFT", 7);
            WEBVIEW = new ImgType("WEBVIEW", 8);
            LOCAL = new ImgType("LOCAL", 9);
            ANTI = new ImgType("ANTI", 10);
            ImgType imgType = new ImgType("NETERROR", 11);
            NETERROR = imgType;
            $VALUES = new ImgType[]{NONE, CREATE, NODATA, FINDBAR, COLLECTION, EMOTION, SINGALL, GIFT, WEBVIEW, LOCAL, ANTI, imgType};
        }

        public ImgType(String str, int i2) {
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

        public static ImgType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImgType) Enum.valueOf(ImgType.class, str) : (ImgType) invokeL.objValue;
        }

        public static ImgType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImgType[]) $VALUES.clone() : (ImgType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public String f40657b;

        public b(String str, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40657b = str;
            this.a = onClickListener;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final b f40658b;

        /* renamed from: c  reason: collision with root package name */
        public final int f40659c;

        /* loaded from: classes11.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public b a;

            /* renamed from: b  reason: collision with root package name */
            public b f40660b;

            /* renamed from: c  reason: collision with root package name */
            public int f40661c;

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
                this.a = null;
                this.f40660b = null;
                this.f40661c = -1;
            }

            public a d(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                    this.f40661c = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public c e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
            }

            public a f(b bVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                    this.a = bVar;
                    return this;
                }
                return (a) invokeL.objValue;
            }
        }

        public /* synthetic */ c(a aVar, a aVar2) {
            this(aVar);
        }

        public static c a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
                a aVar = new a();
                aVar.f(bVar);
                return aVar.e();
            }
            return (c) invokeL.objValue;
        }

        public static c b(b bVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bVar, i2)) == null) {
                a aVar = new a();
                aVar.f(bVar);
                aVar.d(i2);
                return aVar.e();
            }
            return (c) invokeLI.objValue;
        }

        public c(a aVar) {
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
            this.a = aVar.a;
            this.f40658b = aVar.f40660b;
            this.f40659c = aVar.f40661c;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImgType a;

        /* renamed from: b  reason: collision with root package name */
        public final int f40662b;

        /* renamed from: c  reason: collision with root package name */
        public final int f40663c;

        /* renamed from: d  reason: collision with root package name */
        public final int f40664d;

        /* renamed from: e  reason: collision with root package name */
        public final int f40665e;

        /* loaded from: classes11.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ImgType a;

            /* renamed from: b  reason: collision with root package name */
            public int f40666b;

            /* renamed from: c  reason: collision with root package name */
            public int f40667c;

            /* renamed from: d  reason: collision with root package name */
            public int f40668d;

            /* renamed from: e  reason: collision with root package name */
            public int f40669e;

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
                this.a = ImgType.NONE;
                this.f40666b = -1;
                this.f40667c = -1;
                this.f40668d = -1;
                this.f40669e = -1;
            }

            public d f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d(this, null) : (d) invokeV.objValue;
            }

            public a g(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f40668d = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a h(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                    this.f40667c = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a i(ImgType imgType) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imgType)) == null) {
                    this.a = imgType;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a j(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                    this.f40666b = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a k(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                    this.f40669e = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }
        }

        public /* synthetic */ d(a aVar, a aVar2) {
            this(aVar);
        }

        public static d a(ImgType imgType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imgType)) == null) {
                a aVar = new a();
                aVar.i(imgType);
                return aVar.f();
            }
            return (d) invokeL.objValue;
        }

        public static d b(ImgType imgType, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, imgType, i2)) == null) {
                a aVar = new a();
                aVar.i(imgType);
                aVar.j(i2);
                return aVar.f();
            }
            return (d) invokeLI.objValue;
        }

        public static d c(ImgType imgType, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{imgType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                a aVar = new a();
                aVar.i(imgType);
                aVar.h(i2);
                aVar.j(i3);
                aVar.g(i4);
                aVar.k(i5);
                return aVar.f();
            }
            return (d) invokeCommon.objValue;
        }

        public d(a aVar) {
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
            this.a = aVar.a;
            this.f40662b = aVar.f40666b;
            this.f40663c = aVar.f40667c;
            this.f40664d = aVar.f40668d;
            this.f40665e = aVar.f40669e;
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f40670b;

        /* renamed from: c  reason: collision with root package name */
        public final String f40671c;

        /* renamed from: d  reason: collision with root package name */
        public final int f40672d;

        /* renamed from: e  reason: collision with root package name */
        public final int f40673e;

        /* loaded from: classes11.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f40674b;

            /* renamed from: c  reason: collision with root package name */
            public String f40675c;

            /* renamed from: d  reason: collision with root package name */
            public int f40676d;

            /* renamed from: e  reason: collision with root package name */
            public int f40677e;

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
                this.a = null;
                this.f40674b = null;
                this.f40675c = null;
                this.f40676d = -1;
                this.f40677e = 0;
            }

            public e f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this, null) : (e) invokeV.objValue;
            }

            public a g(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    this.f40674b = str;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a h(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.a = str;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a i(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                    this.f40676d = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }
        }

        public /* synthetic */ e(a aVar, a aVar2) {
            this(aVar);
        }

        public static e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? c(TbadkCoreApplication.getInst().getResources().getString(i2)) : (e) invokeI.objValue;
        }

        public static e b(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? d(TbadkCoreApplication.getInst().getResources().getString(i2), TbadkCoreApplication.getInst().getResources().getString(i3)) : (e) invokeII.objValue;
        }

        public static e c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                a aVar = new a();
                aVar.g(str);
                return aVar.f();
            }
            return (e) invokeL.objValue;
        }

        public static e d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
                a aVar = new a();
                aVar.g(str);
                aVar.h(str2);
                return aVar.f();
            }
            return (e) invokeLL.objValue;
        }

        public static e e(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i2, i3)) == null) {
                a aVar = new a();
                aVar.g(TbadkCoreApplication.getInst().getResources().getString(i2));
                aVar.i(i3);
                return aVar.f();
            }
            return (e) invokeII.objValue;
        }

        public e(a aVar) {
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
            this.a = aVar.a;
            this.f40670b = aVar.f40674b;
            this.f40671c = aVar.f40675c;
            this.f40672d = aVar.f40676d;
            this.f40673e = aVar.f40677e;
        }
    }

    public static NoDataView a(Context context, View view, d dVar, e eVar, c cVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, context, view, dVar, eVar, cVar)) == null) ? b(context, view, dVar, eVar, cVar, false) : (NoDataView) invokeLLLLL.objValue;
    }

    public static NoDataView b(Context context, View view, d dVar, e eVar, c cVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, view, dVar, eVar, cVar, Boolean.valueOf(z)})) == null) {
            NoDataView noDataView = new NoDataView(context);
            noDataView.initView(cVar, dVar, eVar);
            if (view != null) {
                if (view instanceof RelativeLayout) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    if (z) {
                        relativeLayout.addView(noDataView, 0);
                    } else {
                        relativeLayout.addView(noDataView);
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) noDataView.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(14);
                    noDataView.setLayoutParams(layoutParams);
                } else if (view instanceof LinearLayout) {
                    ((LinearLayout) view).addView(noDataView);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) noDataView.getLayoutParams();
                    layoutParams2.gravity = 1;
                    noDataView.setLayoutParams(layoutParams2);
                } else if (view instanceof FrameLayout) {
                    ((FrameLayout) view).addView(noDataView, 0);
                }
            }
            noDataView.setVisibility(8);
            return noDataView;
        }
        return (NoDataView) invokeCommon.objValue;
    }
}
