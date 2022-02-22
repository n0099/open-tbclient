package c.a.t0.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                return;
            }
            if (!l.z()) {
                n.M(view.getContext(), j.no_network_guide);
                return;
            }
            b bVar = (b) view.getTag();
            AlaUserInfoData alaUserInfoData = bVar.a;
            if (alaUserInfoData == null) {
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            long j2 = alaUserInfoData.anchor_live;
            if (j2 != 0) {
                alaLiveInfoCoreData.liveID = j2;
            } else {
                long j3 = alaUserInfoData.enter_live;
                if (j3 != 0) {
                    alaLiveInfoCoreData.liveID = j3;
                } else {
                    long j4 = alaUserInfoData.live_id;
                    if (j4 == 0) {
                        return;
                    }
                    alaLiveInfoCoreData.liveID = j4;
                }
            }
            int i2 = bVar.f12842b;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c11850").param("uid", currentAccount));
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                TiebaStatic.log(new StatisticItem("c11851").param("uid", currentAccount));
            } else if (i2 == 5) {
                TiebaStatic.log(new StatisticItem("c11852").param("uid", currentAccount));
            } else if (i2 == 7) {
                if (alaUserInfoData.ala_id != 0) {
                    TiebaStatic.log(new StatisticItem("c11855").param("uid", currentAccount).param("click_uid", alaUserInfoData.ala_id).param(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfoData.live_status));
                }
                TiebaStatic.log(new StatisticItem("c12542"));
                if (bVar.f12843c && !StringUtils.isNull(alaUserInfoData.sex)) {
                    BdToast.i(view.getContext(), String.format(view.getContext().getString(j.person_privacy_toast), alaUserInfoData.sex), c.a.u0.a4.f.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
            }
            int i3 = bVar.f12842b;
            MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, i3 == 5 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION : i3 == 7 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY : AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT, null, false, "")));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1139783694, "Lc/a/t0/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1139783694, "Lc/a/t0/e/d;");
                return;
            }
        }
        a = new a();
    }

    public static TextView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
                return null;
            }
            TextView textView = (TextView) LayoutInflater.from(context).inflate(h.ala_tail_view_layout, (ViewGroup) null);
            textView.setOnClickListener(a);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }
}
