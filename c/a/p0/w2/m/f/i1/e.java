package c.a.p0.w2.m.f.i1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f20095b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20096c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f20097d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20098e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20099f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20100g;

    public e(PbFragment pbFragment, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20095b = null;
        this.a = pbFragment;
        this.f20095b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i) == null) || bdTypeListView == null || (relativeLayout = this.f20096c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f20096c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06a7, (ViewGroup) null);
            this.f20096c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090feb);
            this.f20097d = headImageView;
            headImageView.setIsRound(true);
            this.f20097d.setPlaceHolder(1);
            this.f20098e = (TextView) this.f20096c.findViewById(R.id.obfuscated_res_0x7f0921ec);
            this.f20099f = (TextView) this.f20096c.findViewById(R.id.obfuscated_res_0x7f0921eb);
            this.f20100g = (ImageView) this.f20096c.findViewById(R.id.obfuscated_res_0x7f090fea);
            this.f20096c.setOnClickListener(this.f20095b);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            RelativeLayout relativeLayout = this.f20096c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
            }
            HeadImageView headImageView = this.f20097d;
            if (headImageView != null) {
                headImageView.setSkinType(i);
            }
            TextView textView = this.f20098e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.f20099f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.f20100g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f20096c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(c.a.p0.w2.i.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, bdTypeListView) == null) || fVar == null || bdTypeListView == null) {
            return;
        }
        if (fVar.O().isVideoThreadType() && fVar.O().getSmartApp() != null) {
            SmartApp smartApp = fVar.O().getSmartApp();
            this.f20096c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!m.isEmpty(smartApp.avatar)) {
                this.f20097d.K(smartApp.avatar, 10, false, false);
            }
            if (!m.isEmpty(smartApp.name)) {
                charSequence = smartApp.name + " " + ((Object) this.a.getText(R.string.obfuscated_res_0x7f0f1182));
            } else {
                charSequence = this.a.getText(R.string.obfuscated_res_0x7f0f08ec).toString();
            }
            this.f20098e.setText(charSequence);
            if (!m.isEmpty(smartApp._abstract)) {
                this.f20099f.setText(smartApp._abstract);
            } else {
                this.f20099f.setText(this.a.getText(R.string.obfuscated_res_0x7f0f1181));
            }
            this.f20096c.setTag(smartApp);
            return;
        }
        this.f20096c.setVisibility(8);
        d(bdTypeListView);
    }
}
