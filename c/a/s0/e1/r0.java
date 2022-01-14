package c.a.s0.e1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.schemeaction.UriBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WXMediaMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IWXAPI f12426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SendMessageToWX.Req f12427c;

        public a(WXMediaMessage wXMediaMessage, IWXAPI iwxapi, SendMessageToWX.Req req) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wXMediaMessage, iwxapi, req};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wXMediaMessage;
            this.f12426b = iwxapi;
            this.f12427c = req;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    this.a.thumbData = r0.a(p);
                } else {
                    Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.pic_wechatguide_head);
                    this.a.thumbData = r0.a(cashBitmap);
                }
                this.f12426b.sendReq(this.f12427c);
            }
        }
    }

    public static byte[] a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bitmap)) == null) {
            if (bitmap == null) {
                try {
                    bitmap = BitmapHelper.getCashBitmap(R.drawable.pic_wechatguide_head);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return String.valueOf(System.currentTimeMillis());
            }
            return str + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(268435456);
                intent.setComponent(componentName);
                context.startActivity(intent);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static void d(TiebaPlusInfo tiebaPlusInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tiebaPlusInfo, str) == null) {
            UriBuilder uriBuilder = new UriBuilder(tiebaPlusInfo.h5_jump_param);
            if (uriBuilder.getParamsObject() != null) {
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                String string = uriBuilder.getParamsObject().getString("url");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                wXWebpageObject.webpageUrl = string;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                wXMediaMessage.title = str;
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = b("webpage");
                req.message = wXMediaMessage;
                req.scene = 1;
                c.a.d.f.l.d.h().k(tiebaPlusInfo.wx_thumbnail, 10, new a(wXMediaMessage, WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), TbConfig.WEIXIN_APP_ID), req), 0, 0, null, new Object[0]);
            }
        }
    }
}
