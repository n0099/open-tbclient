package c.a.o0.s.x;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStaticClassesArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f14247a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f14248b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(964202738, "Lc/a/o0/s/x/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(964202738, "Lc/a/o0/s/x/d;");
                return;
            }
        }
        f14247a = new String[]{"com.baidu.tieba.livesdk.AlaLiveSdkStatic", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.advert.sdk.AdvertSDKStatic", "com.baidu.tieba.funad.FunAdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.wallet.PayStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.flutter.FlutterStatic"};
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                TiebaStaticClassesArray tiebaStaticClassesArray = new TiebaStaticClassesArray();
                boolean z = true;
                try {
                    Class<?> cls = Class.forName("com.baidu.tbadk.core.util.TiebaStaticArray");
                    Object newInstance = cls.newInstance();
                    Field declaredField = cls.getDeclaredField("staticClassesArray");
                    declaredField.setAccessible(true);
                    tiebaStaticClassesArray.staticClassesArray = (String[]) declaredField.get(newInstance);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String str = "" + tiebaStaticClassesArray.staticClassesArray.length;
                if (c.a.o0.s.d0.b.j().k("static_opt_open", 0) <= 0) {
                    z = false;
                }
                f14248b = z;
                long currentTimeMillis = System.currentTimeMillis();
                if (f14248b) {
                    if (b()) {
                        MultiDexHelper.loadClass(BdBaseApplication.getInst());
                    } else if (!tiebaStaticClassesArray.loadStaticClasses()) {
                        MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                    }
                } else if (!tiebaStaticClassesArray.loadStaticClasses()) {
                    MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                }
                String str2 = "load from dex coast time " + (System.currentTimeMillis() - currentTimeMillis);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (f14247a.length <= 0) {
                    return false;
                }
                for (String str : f14247a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Class.forName(str);
                    String str2 = str + " " + (System.currentTimeMillis() - currentTimeMillis);
                }
                return true;
            } catch (Throwable th) {
                BdLog.e(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
