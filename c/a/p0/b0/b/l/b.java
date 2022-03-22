package c.a.p0.b0.b.l;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.d(true);
            }
        }
    }

    /* renamed from: c.a.p0.b0.b.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnCancelListenerC0938b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public DialogInterface$OnCancelListenerC0938b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final int b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            if (str.equals(Share.WEIXIN_FRIEND)) {
                return 3;
            }
            if (str.equals(Share.WEIXIN_TIMELINE)) {
                return 2;
            }
            if (str.equals(Share.QQFRIEND)) {
                return 8;
            }
            if (str.equals(Share.QQDENGLU)) {
                return 4;
            }
            if (str.equals(Share.SINAWEIBO)) {
                return 6;
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mResult.putBoolean("share_result", z);
            f();
            finish();
        }
    }

    public final void e(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, str) == null) {
            if (activity == null) {
                d(false);
                return;
            }
            c.a.p0.b0.b.l.a aVar = new c.a.p0.b0.b.l.a();
            try {
                aVar.p(new JSONObject(str));
                TbadkCoreApplication.getInst().setCurAiAppid(aVar.o0);
                if (!TextUtils.isEmpty(aVar.n())) {
                    int b2 = b(-1, aVar.n());
                    if (!TextUtils.isEmpty(aVar.m()) && !TextUtils.isEmpty(aVar.l())) {
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                        httpMessage.addParam("scheme", aVar.m());
                        httpMessage.setExtra(new c.a.o0.r.n.b(aVar, activity, b2, new a(this)));
                        MessageManager.getInstance().sendMessage(httpMessage);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, b2, aVar, true));
                    d(c.a.o0.s.g.a.b(activity, b2));
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13530").param("obj_id", aVar.o0).param("obj_type", aVar.p0).param("obj_source", aVar.q0));
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
                shareDialogConfig.onCancelListener = new DialogInterface$OnCancelListenerC0938b(this);
                shareDialogConfig.onDismissListener = new c(this);
                JSONArray o = aVar.o();
                if (o != null && !TextUtils.isEmpty(aVar.m()) && !TextUtils.isEmpty(aVar.l())) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < o.length(); i++) {
                        try {
                            arrayList.add(Integer.valueOf(b(-1, o.getString(i))));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!ListUtils.isEmpty(arrayList)) {
                        aVar.h(arrayList);
                    }
                    HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage2.addParam("scheme", aVar.m());
                    httpMessage2.setExtra(new c.a.o0.r.n.b(aVar, activity, shareDialogConfig.onCancelListener));
                    MessageManager.getInstance().sendMessage(httpMessage2);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } catch (JSONException unused) {
                d(false);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c();
            e(getAgent(), this.mParams.getString("options"));
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f();
        }
    }
}
