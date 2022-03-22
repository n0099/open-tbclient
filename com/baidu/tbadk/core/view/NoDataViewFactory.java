package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NoDataViewFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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
            NONE = new ImgType("NONE", 0);
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

        public ImgType(String str, int i) {
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public String f30046b;

        public b(String str, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30046b = str;
            this.a = onClickListener;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final b f30047b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30048c;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public b a;

            /* renamed from: b  reason: collision with root package name */
            public b f30049b;

            /* renamed from: c  reason: collision with root package name */
            public int f30050c;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = null;
                this.f30049b = null;
                this.f30050c = -1;
            }

            public a d(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                    this.f30050c = i;
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

        public static c b(b bVar, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bVar, i)) == null) {
                a aVar = new a();
                aVar.f(bVar);
                aVar.d(i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar.a;
            this.f30047b = aVar.f30049b;
            this.f30048c = aVar.f30050c;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImgType a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30051b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30052c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30053d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30054e;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ImgType a;

            /* renamed from: b  reason: collision with root package name */
            public int f30055b;

            /* renamed from: c  reason: collision with root package name */
            public int f30056c;

            /* renamed from: d  reason: collision with root package name */
            public int f30057d;

            /* renamed from: e  reason: collision with root package name */
            public int f30058e;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ImgType.NONE;
                this.f30055b = -1;
                this.f30056c = -1;
                this.f30057d = -1;
                this.f30058e = -1;
            }

            public d f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d(this, null) : (d) invokeV.objValue;
            }

            public a g(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    this.f30057d = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a h(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    this.f30056c = i;
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

            public a j(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                    this.f30055b = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a k(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                    this.f30058e = i;
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

        public static d b(ImgType imgType, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, imgType, i)) == null) {
                a aVar = new a();
                aVar.i(imgType);
                aVar.j(i);
                return aVar.f();
            }
            return (d) invokeLI.objValue;
        }

        public static d c(ImgType imgType, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{imgType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                a aVar = new a();
                aVar.i(imgType);
                aVar.h(i);
                aVar.j(i2);
                aVar.g(i3);
                aVar.k(i4);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar.a;
            this.f30051b = aVar.f30055b;
            this.f30052c = aVar.f30056c;
            this.f30053d = aVar.f30057d;
            this.f30054e = aVar.f30058e;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30059b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30060c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30061d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30062e;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f30063b;

            /* renamed from: c  reason: collision with root package name */
            public String f30064c;

            /* renamed from: d  reason: collision with root package name */
            public int f30065d;

            /* renamed from: e  reason: collision with root package name */
            public int f30066e;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = null;
                this.f30063b = null;
                this.f30064c = null;
                this.f30065d = -1;
                this.f30066e = 0;
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
                    this.f30063b = str;
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

            public a i(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                    this.f30065d = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }
        }

        public /* synthetic */ e(a aVar, a aVar2) {
            this(aVar);
        }

        public static e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? c(TbadkCoreApplication.getInst().getResources().getString(i)) : (e) invokeI.objValue;
        }

        public static e b(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? d(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2)) : (e) invokeII.objValue;
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

        public static e e(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) {
                a aVar = new a();
                aVar.g(TbadkCoreApplication.getInst().getResources().getString(i));
                aVar.i(i2);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar.a;
            this.f30059b = aVar.f30063b;
            this.f30060c = aVar.f30064c;
            this.f30061d = aVar.f30065d;
            this.f30062e = aVar.f30066e;
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
            noDataView.c(cVar, dVar, eVar);
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
