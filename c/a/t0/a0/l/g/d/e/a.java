package c.a.t0.a0.l.g.d.e;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15393b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15394c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15395d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15396e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15397f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15398g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15399h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15400i;

    /* renamed from: j  reason: collision with root package name */
    public b f15401j;

    /* renamed from: k  reason: collision with root package name */
    public AlaEnterEffectData f15402k;
    public Context l;

    /* renamed from: c.a.t0.a0.l.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0941a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15403e;

        public View$OnClickListenerC0941a(a aVar) {
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
            this.f15403e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15403e.f15401j == null) {
                return;
            }
            this.f15403e.f15401j.a();
        }
    }

    /* loaded from: classes6.dex */
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
        this.f15402k = alaEnterEffectData;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
        this.a = relativeLayout;
        this.f15393b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f15394c = (TextView) this.a.findViewById(R.id.left_time_tv);
        this.f15395d = (TextView) this.a.findViewById(R.id.live_room_tv);
        this.f15396e = (TextView) this.a.findViewById(R.id.confirm_button_tv);
        this.f15397f = (TextView) this.a.findViewById(R.id.t_dou_price);
        this.f15398g = (LinearLayout) this.a.findViewById(R.id.t_dou_price_layout);
        this.f15399h = (LinearLayout) this.a.findViewById(R.id.cur_t_dou_layout);
        this.f15400i = (TextView) this.a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (RelativeLayout) invokeV.objValue;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.f15402k = alaEnterEffectData;
        this.f15396e.setEnabled(true);
        int i2 = this.f15402k.categoryType;
        if (3 != i2) {
            if (2 == i2) {
                this.f15396e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f15396e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f15398g.setVisibility(0);
                this.f15397f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f15397f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f15397f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f15399h.setVisibility(0);
                this.f15400i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f15400i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.f15400i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f15395d.setVisibility(0);
                this.f15396e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f15396e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.f15402k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f15396e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f15396e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f15396e.setText(R.string.ala_stop_use);
                if (2 == this.f15402k.categoryType) {
                    this.f15399h.setVisibility(8);
                }
            } else {
                this.f15396e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i3 = alaEnterEffectData2.categoryType;
            if (3 == i3) {
                this.f15396e.setText(R.string.ala_nobility_open);
                this.f15394c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i3) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.f15402k.price) {
                    this.f15396e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f15396e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f15396e.setBackgroundDrawable(null);
                this.f15396e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f15396e.setText(R.string.ala_enter_effect_not_own);
                this.f15396e.setEnabled(false);
            }
        }
        this.f15396e.setOnClickListener(new View$OnClickListenerC0941a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f15393b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f15394c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f15395d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        AlaEnterEffectData alaEnterEffectData;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaEnterEffectData = this.f15402k) == null || 2 != alaEnterEffectData.categoryType || (textView = this.f15396e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f15401j = bVar;
        }
    }
}
