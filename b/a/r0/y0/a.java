package b.a.r0.y0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f27227b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f27228a;

    /* renamed from: b.a.r0.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1340a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1340a(a aVar) {
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
                }
            }
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27229a;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27229a = str;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.f27229a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.f27229a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f27230a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f27231b;

        public c(a aVar, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27230a = hVar;
            this.f27231b = str;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                h hVar = this.f27230a;
                if (hVar != null) {
                    hVar.a(str, i2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f27231b).param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.f27230a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f27231b).param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f27232a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f27233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f27234c;

        public d(a aVar, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27234c = aVar;
            this.f27232a = hVar;
            this.f27233b = str;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                h hVar = this.f27232a;
                if (hVar != null) {
                    hVar.a(str, i2);
                }
                this.f27234c.z(0, this.f27233b, String.valueOf(1));
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.f27232a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f27234c.z(1, this.f27233b, String.valueOf(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27235a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f27236b;

        public e(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27235a = str;
            this.f27236b = str2;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.f27235a, this.f27236b, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0));
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.f27235a, this.f27236b, "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(String str);

        void b(ImageView imageView, Object obj);

        void c(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar);

        ViewGroup d(@NonNull Context context);

        void destroyAd(String str);

        View e(Object obj);

        boolean f(Activity activity);

        void g(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        boolean h(Object obj);

        Object i(@NonNull Activity activity, @NonNull String str);

        boolean isAdReady(String str);

        void j(Context context, String str, h hVar, g gVar);

        void k(Object obj, j jVar);

        void l(Application application, l lVar);

        void m(Activity activity, String str, h hVar, g gVar);

        void n(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        b.a.r0.z3.g o(Object obj);

        void removeMiniWindow();
    }

    /* loaded from: classes5.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27237a;

        /* renamed from: b  reason: collision with root package name */
        public String f27238b;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(String str, int i2);

        void onError(String str);
    }

    /* loaded from: classes5.dex */
    public interface i {
        void onAdClicked(String str, String str2, String str3);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str, String str2, String str3);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void a(long j, long j2);
    }

    /* loaded from: classes5.dex */
    public static abstract class k implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface l {
        void a();
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
        this.f27228a = g();
    }

    public static g b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            g gVar = new g();
            gVar.f27237a = str;
            gVar.f27238b = str2;
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f27227b == null) {
                synchronized (a.class) {
                    if (f27227b == null) {
                        f27227b = new a();
                    }
                }
            }
            if (f27227b.f27228a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                f27227b = new a();
            }
            return f27227b;
        }
        return (a) invokeV.objValue;
    }

    public b.a.r0.z3.g A(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f27228a.o(obj) : (b.a.r0.z3.g) invokeL.objValue;
    }

    public boolean B(Activity activity, String str, g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, gVar)) == null) {
            if (this.f27228a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.f27228a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
            System.currentTimeMillis();
            FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
            this.f27228a.m(activity, str, new C1340a(this), gVar);
            return isAdReady;
        }
        return invokeLLL.booleanValue;
    }

    public boolean C(Activity activity, String str, g gVar, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, gVar, str2)) == null) {
            if (this.f27228a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.f27228a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
            FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
            this.f27228a.m(activity, str, new b(this, str2), gVar);
            return isAdReady;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean D(Activity activity, String str, g gVar, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, activity, str, gVar, str2, str3)) == null) {
            if (this.f27228a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.f27228a.isAdReady(str);
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, str2, str3, null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str2).param("fid", str3).param("obj_type", "a005").param("obj_param1", "2"));
            this.f27228a.m(activity, str, new e(this, str2, str3), gVar);
            return isAdReady;
        }
        return invokeLLLLL.booleanValue;
    }

    public void c(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.a(str);
    }

    public void d(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.destroyAd(str);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b.a.q0.t.c.e.g() : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.q0.t.c.e.h() : invokeV.intValue;
    }

    public final f g() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, f.class)) != null) {
                return (f) runTask.getData();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public ViewGroup h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            f fVar = this.f27228a;
            if (fVar != null) {
                return fVar.d(context);
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public Object j(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, activity, str)) == null) {
            f fVar = this.f27228a;
            if (fVar != null) {
                return fVar.i(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public View k(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? this.f27228a.e(obj) : (View) invokeL.objValue;
    }

    public void l() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.l(TbadkCoreApplication.getInst(), null);
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            f fVar = this.f27228a;
            return fVar != null && fVar.isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    public void n(Context context, String str, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048590, this, context, str, hVar, gVar) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.j(context, str, hVar, gVar);
    }

    public void o(Activity activity, String str, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048591, this, activity, str, hVar, gVar) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.m(activity, str, hVar, gVar);
    }

    public void p(Activity activity, h hVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, activity, hVar, str) == null) || this.f27228a == null) {
            return;
        }
        z(2, str, "");
        this.f27228a.m(activity, "6061002410-390177882", new d(this, hVar, str), b(str, (VideoMiddleAdSwitch.isOn() && b.a.q0.b.d.Z()) ? "1" : "0"));
    }

    public void q(Activity activity, h hVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, activity, hVar, str) == null) || this.f27228a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        this.f27228a.m(activity, "6061002332-203360688", new c(this, hVar, str), b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, VideoMiddleAdSwitch.isOn() ? "1" : "0"));
    }

    public void r() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.removeMiniWindow();
    }

    public void s(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, imageView, obj) == null) {
            this.f27228a.b(imageView, obj);
        }
    }

    public void t(Object obj, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, obj, jVar) == null) {
            this.f27228a.k(obj, jVar);
        }
    }

    public boolean u(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) ? this.f27228a.h(obj) : invokeL.booleanValue;
    }

    public void v(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048598, this, activity, str, viewGroup, iVar, gVar) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.n(activity, str, viewGroup, iVar, gVar);
    }

    public boolean w(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, activity)) == null) {
            f fVar = this.f27228a;
            return fVar != null && fVar.f(activity);
        }
        return invokeL.booleanValue;
    }

    public void x(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar}) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.c(activity, obj, iVar, viewGroup, list, list2, gVar);
    }

    public void y(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048601, this, activity, str, viewGroup, iVar, gVar) == null) || (fVar = this.f27228a) == null) {
            return;
        }
        fVar.g(activity, str, viewGroup, iVar, gVar);
    }

    public final void z(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048602, this, i2, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", i2).param("tid", "").param("fid", "").param("obj_type", str).param(TiebaStatic.Params.RESOURCE_ID, str2));
        }
    }
}
