package c.a.p0.c0.l.g.d.e;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13370b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13371c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13372d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13373e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13374f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f13375g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f13376h;
    public TextView i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: c.a.p0.c0.l.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1009a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1009a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.j == null) {
                return;
            }
            this.a.j.a();
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00f0, (ViewGroup) null);
        this.a = relativeLayout;
        this.f13370b = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090868);
        this.f13371c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091227);
        this.f13372d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0912c3);
        this.f13373e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906bd);
        this.f13374f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e34);
        this.f13375g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e35);
        this.f13376h = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09072f);
        this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09072e);
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
        this.k = alaEnterEffectData;
        this.f13373e.setEnabled(true);
        int i = this.k.categoryType;
        if (3 != i) {
            if (2 == i) {
                this.f13373e.setBackgroundResource(R.drawable.obfuscated_res_0x7f0801d5);
                this.f13373e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f13375g.setVisibility(0);
                this.f13374f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f13374f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234));
                this.f13374f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f13376h.setVisibility(0);
                this.i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                this.i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f13372d.setVisibility(0);
                this.f13373e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d3c);
                this.f13373e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f06077d));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f13373e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d39);
                this.f13373e.setTextColor(this.l.getResources().getColorStateList(R.color.obfuscated_res_0x7f06077c));
                this.f13373e.setText(R.string.obfuscated_res_0x7f0f0241);
                if (2 == this.k.categoryType) {
                    this.f13376h.setVisibility(8);
                }
            } else {
                this.f13373e.setText(R.string.obfuscated_res_0x7f0f0215);
            }
        } else {
            int i2 = alaEnterEffectData2.categoryType;
            if (3 == i2) {
                this.f13373e.setText(R.string.obfuscated_res_0x7f0f022e);
                this.f13371c.setText(this.l.getString(R.string.obfuscated_res_0x7f0f0207, alaEnterEffectData.nobilityName));
            } else if (2 == i2) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f13373e.setText(R.string.obfuscated_res_0x7f0f020c);
                } else {
                    this.f13373e.setText(R.string.obfuscated_res_0x7f0f0205);
                }
            } else {
                this.f13373e.setBackgroundDrawable(null);
                this.f13373e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f13373e.setText(R.string.obfuscated_res_0x7f0f0209);
                this.f13373e.setEnabled(false);
            }
        }
        this.f13373e.setOnClickListener(new View$OnClickListenerC1009a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f13370b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f13371c.setText(this.l.getResources().getString(R.string.obfuscated_res_0x7f0f0218, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f13372d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        AlaEnterEffectData alaEnterEffectData;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaEnterEffectData = this.k) == null || 2 != alaEnterEffectData.categoryType || (textView = this.f13373e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.j = bVar;
        }
    }
}
