package c.a.s0.s.x;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStaticClassesArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static String[] a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13673b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f13674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TiebaStaticClassesArray f13675f;

        public a(boolean z, TiebaStaticClassesArray tiebaStaticClassesArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), tiebaStaticClassesArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13674e = z;
            this.f13675f = tiebaStaticClassesArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f13674e) {
                        MultiDexHelper.loadClass(BdBaseApplication.getInst());
                    } else if (this.f13675f.loadStaticClasses()) {
                    } else {
                        MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1970647818, "Lc/a/s0/s/x/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1970647818, "Lc/a/s0/s/x/d;");
                return;
            }
        }
        a = new String[]{"com.baidu.tieba.tbadvert.TbAdvertStatic", "com.baidu.tieba.homepage.personalize.PersonalizeStatic", "com.baidu.tieba.livesdk.AlaLiveSdkStatic", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.ad.browser.AdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.wallet.PayStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.videoplay.fragment.VideoChannelDelegateStatic", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.flutter.FlutterStatic", "com.baidu.tieba.square.ForumSquareStatic", "com.baidu.tieba.homepage.topic.TopicStatic", "com.baidu.tieba.quickWebView.QuickWebViewStatic", "com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic", "com.baidu.tieba.hottopic.controller.HotTopicStatic"};
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
                if (c.a.s0.s.h0.b.k().l("static_opt_open", 0) <= 0) {
                    z = false;
                }
                f13673b = z;
                long currentTimeMillis = System.currentTimeMillis();
                if (f13673b) {
                    c.a.d.e.a.b().a("MultiDexHelper", new a(b(), tiebaStaticClassesArray));
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String[] strArr = a;
            try {
                if (strArr.length <= 0) {
                    return false;
                }
                for (String str : strArr) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Class.forName(str);
                    String str2 = str + " " + (System.currentTimeMillis() - currentTimeMillis);
                }
                return true;
            } catch (Throwable th) {
                BdLog.e(th, true);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
