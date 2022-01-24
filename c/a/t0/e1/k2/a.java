package c.a.t0.e1.k2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import c.a.s0.s.a0.l;
import c.a.s0.s.a0.n;
import c.a.s0.s.a0.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public l f16563c;

    /* renamed from: d  reason: collision with root package name */
    public String f16564d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar, String str) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16563c = lVar;
        this.f16564d = str;
    }

    @o(isAsync = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString(TTDownloadField.TT_DOWNLOAD_URL);
        String optString3 = jSONObject.optString("imageUrl");
        if (StringUtils.isNull(optString)) {
            return;
        }
        if (!c.a.d.f.p.l.z()) {
            UtilHelper.showToast(getContext(), R.string.neterror);
            return;
        }
        if (StringUtils.isNull(optString2)) {
            g(optString);
        } else {
            c.a.t0.k3.f0.e.n().E(optString, optString2, optString, 0, c.a.t0.k3.f0.e.o(optString).intValue(), null, true, false, true, optString3, null, null);
        }
        TiebaStatic.log(new StatisticItem("c12775").param("fid", StringUtils.isNull(this.f16564d) ? "" : this.f16564d));
    }

    @Override // c.a.s0.s.a0.n
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_DOWNLOAD_GAME" : (String) invokeV.objValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            try {
                if (!(this.f16563c.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                this.f16563c.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
