package b.a.q0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes4.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14065a;

    /* renamed from: b  reason: collision with root package name */
    public int f14066b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14067c;

    public e0() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14065a = jSONObject.optInt("is_bawu") == 1;
        this.f14066b = "manager".equals(jSONObject.optString("bawu_type")) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(jSONObject.optString("bawu_type")) ? 2 : 0;
        this.f14067c = jSONObject.optInt("is_deleted") == 1;
    }

    public void b(MultiForumPerm multiForumPerm) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiForumPerm) == null) || multiForumPerm == null) {
            return;
        }
        this.f14065a = multiForumPerm.is_bawu.intValue() == 1;
        this.f14066b = "manager".equals(multiForumPerm.bawu_type) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
        this.f14067c = multiForumPerm.is_deleted.intValue() == 1;
    }
}
