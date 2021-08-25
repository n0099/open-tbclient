package c.a.q0.v.j.g.d.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f25772a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25773b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25774c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25775d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25776e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25777f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f25778g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25779h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25780i;

    /* renamed from: j  reason: collision with root package name */
    public b f25781j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: c.a.q0.v.j.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1204a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25782e;

        public View$OnClickListenerC1204a(a aVar) {
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
                    return;
                }
            }
            this.f25782e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25782e.f25781j == null) {
                return;
            }
            this.f25782e.f25781j.a();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaEnterEffectData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (alaEnterEffectData == null || context == null) {
            return;
        }
        this.l = context;
        this.k = alaEnterEffectData;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
        this.f25772a = relativeLayout;
        this.f25773b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f25774c = (TextView) this.f25772a.findViewById(R.id.left_time_tv);
        this.f25775d = (TextView) this.f25772a.findViewById(R.id.live_room_tv);
        this.f25776e = (TextView) this.f25772a.findViewById(R.id.confirm_button_tv);
        this.f25777f = (TextView) this.f25772a.findViewById(R.id.t_dou_price);
        this.f25778g = (LinearLayout) this.f25772a.findViewById(R.id.t_dou_price_layout);
        this.f25779h = (LinearLayout) this.f25772a.findViewById(R.id.cur_t_dou_layout);
        this.f25780i = (TextView) this.f25772a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25772a : (RelativeLayout) invokeV.objValue;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.f25776e.setEnabled(true);
        int i2 = this.k.categoryType;
        if (3 != i2) {
            if (2 == i2) {
                this.f25776e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f25776e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f25778g.setVisibility(0);
                this.f25777f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f25777f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f25777f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f25779h.setVisibility(0);
                this.f25780i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f25780i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.f25780i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f25775d.setVisibility(0);
                this.f25776e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f25776e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f25776e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f25776e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f25776e.setText(R.string.ala_stop_use);
                if (2 == this.k.categoryType) {
                    this.f25779h.setVisibility(8);
                }
            } else {
                this.f25776e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i3 = alaEnterEffectData2.categoryType;
            if (3 == i3) {
                this.f25776e.setText(R.string.ala_nobility_open);
                this.f25774c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i3) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f25776e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f25776e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f25776e.setBackgroundDrawable(null);
                this.f25776e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f25776e.setText(R.string.ala_enter_effect_not_own);
                this.f25776e.setEnabled(false);
            }
        }
        this.f25776e.setOnClickListener(new View$OnClickListenerC1204a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f25773b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f25774c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f25775d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        AlaEnterEffectData alaEnterEffectData;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaEnterEffectData = this.k) == null || 2 != alaEnterEffectData.categoryType || (textView = this.f25776e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f25781j = bVar;
        }
    }
}
