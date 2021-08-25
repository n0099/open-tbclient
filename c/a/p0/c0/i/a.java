package c.a.p0.c0.i;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13011a;

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
        this.f13011a = "";
    }

    @Override // c.a.p0.c0.i.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CloudControlRequest.REQUEST_KEY_FILTER : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b3, code lost:
        if (r0 != r2) goto L33;
     */
    @Override // c.a.p0.c0.i.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, z)) == null) {
            Bitmap bitmap2 = null;
            if (bitmap == null) {
                return null;
            }
            c.a.p0.b0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
            if ("normal".equals(this.f13011a)) {
                return bitmap;
            }
            MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
            if (!bitmap.isMutable()) {
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = TbConfig.BitmapConfig;
                }
                Bitmap copy = bitmap.copy(config, true);
                if (copy != null) {
                    try {
                        if (motuPlugin != null) {
                            try {
                                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst(), this.f13011a, copy);
                            } catch (IllegalStateException e2) {
                                BdLog.e(e2.toString());
                                e2.printStackTrace();
                            } catch (Throwable th) {
                                BdLog.e(th.toString());
                                th.printStackTrace();
                                if (copy != null && copy != null) {
                                }
                            }
                        }
                    } finally {
                        if (copy != null && copy != null) {
                            copy.recycle();
                        }
                    }
                }
                if (copy != null) {
                }
            } else if (motuPlugin != null) {
                try {
                    bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst().getApp(), this.f13011a, bitmap);
                } catch (Throwable th2) {
                    TiebaStatic.imgError(-1008, "motou filter failed: " + th2.toString(), "");
                    if (BdLog.isDebugMode()) {
                        th2.printStackTrace();
                    }
                }
            }
            if (bitmap2 == null) {
                return bitmap;
            }
            if (z && bitmap2 != bitmap) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @Override // c.a.p0.c0.i.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
            return;
        }
        this.f13011a = str;
    }
}
