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
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes4.dex */
public class NoDataViewFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;
        public final b b;
        public final int c;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public b a;
            public b b;
            public int c;

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
                this.b = null;
                this.c = -1;
            }

            public c e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return new c(this, null);
                }
                return (c) invokeV.objValue;
            }

            public a d(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                    this.c = i;
                    return this;
                }
                return (a) invokeI.objValue;
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
            this.b = aVar.b;
            this.c = aVar.c;
        }

        public /* synthetic */ c(a aVar, a aVar2) {
            this(aVar);
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
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImgType a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ImgType a;
            public int b;
            public int c;
            public int d;
            public int e;

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
                this.b = -1;
                this.c = -1;
                this.d = -1;
                this.e = -1;
            }

            public d f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new d(this, null);
                }
                return (d) invokeV.objValue;
            }

            public a g(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    this.d = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a h(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    this.c = i;
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
                    this.b = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a k(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                    this.e = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }
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
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }

        public /* synthetic */ d(a aVar, a aVar2) {
            this(aVar);
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
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public String b;
            public String c;
            public int d;
            public int e;

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
                this.b = null;
                this.c = null;
                this.d = -1;
                this.e = 0;
            }

            public e f() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new e(this, null);
                }
                return (e) invokeV.objValue;
            }

            public a g(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    this.b = str;
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
                    this.d = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }
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
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }

        public /* synthetic */ e(a aVar, a aVar2) {
            this(aVar);
        }

        public static e b(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
                return d(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
            }
            return (e) invokeII.objValue;
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

        public static e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                return c(TbadkCoreApplication.getInst().getResources().getString(i));
            }
            return (e) invokeI.objValue;
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ImgType {
        public static final /* synthetic */ ImgType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImgType ANTI;
        public static final ImgType COLLECTION;
        public static final ImgType CREATE;
        public static final ImgType EMOTION;
        public static final ImgType FINDBAR;
        public static final ImgType LOCAL;
        public static final ImgType NETERROR;
        public static final ImgType NODATA;
        public static final ImgType NOFOLLOW;
        public static final ImgType NONE;
        public static final ImgType NOPOST;
        public static final ImgType NORESULT;
        public static final ImgType NOTLOGIN;
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
            NONE = new ImgType(HlsPlaylistParser.METHOD_NONE, 0);
            CREATE = new ImgType("CREATE", 1);
            NODATA = new ImgType("NODATA", 2);
            FINDBAR = new ImgType("FINDBAR", 3);
            COLLECTION = new ImgType("COLLECTION", 4);
            EMOTION = new ImgType("EMOTION", 5);
            NOPOST = new ImgType("NOPOST", 6);
            NOFOLLOW = new ImgType("NOFOLLOW", 7);
            NORESULT = new ImgType("NORESULT", 8);
            WEBVIEW = new ImgType("WEBVIEW", 9);
            LOCAL = new ImgType("LOCAL", 10);
            ANTI = new ImgType("ANTI", 11);
            NETERROR = new ImgType("NETERROR", 12);
            ImgType imgType = new ImgType("NOTLOGIN", 13);
            NOTLOGIN = imgType;
            $VALUES = new ImgType[]{NONE, CREATE, NODATA, FINDBAR, COLLECTION, EMOTION, NOPOST, NOFOLLOW, NORESULT, WEBVIEW, LOCAL, ANTI, NETERROR, imgType};
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ImgType) Enum.valueOf(ImgType.class, str);
            }
            return (ImgType) invokeL.objValue;
        }

        public static ImgType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ImgType[]) $VALUES.clone();
            }
            return (ImgType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public String b;

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
            this.b = str;
            this.a = onClickListener;
        }
    }

    public static NoDataView a(Context context, View view2, d dVar, e eVar, c cVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, context, view2, dVar, eVar, cVar)) == null) {
            return b(context, view2, dVar, eVar, cVar, false);
        }
        return (NoDataView) invokeLLLLL.objValue;
    }

    public static NoDataView b(Context context, View view2, d dVar, e eVar, c cVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, view2, dVar, eVar, cVar, Boolean.valueOf(z)})) == null) {
            NoDataView noDataView = new NoDataView(context);
            noDataView.c(cVar, dVar, eVar);
            if (view2 != null) {
                if (view2 instanceof RelativeLayout) {
                    RelativeLayout relativeLayout = (RelativeLayout) view2;
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
                } else if (view2 instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) view2;
                    if (z) {
                        linearLayout.addView(noDataView, 0);
                    } else {
                        linearLayout.addView(noDataView);
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) noDataView.getLayoutParams();
                    layoutParams2.gravity = 1;
                    noDataView.setLayoutParams(layoutParams2);
                } else if (view2 instanceof FrameLayout) {
                    ((FrameLayout) view2).addView(noDataView, 0);
                }
            }
            noDataView.setVisibility(8);
            return noDataView;
        }
        return (NoDataView) invokeCommon.objValue;
    }
}
