package b.a.r0.k2.u.f.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19006a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f19007b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19008c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f19009d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19010e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19011f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19012g;

    public e(PbFragment pbFragment, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19007b = null;
        this.f19006a = pbFragment;
        this.f19007b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null || (relativeLayout = this.f19008c) == null) {
            return;
        }
        bdTypeListView.addHeaderView(relativeLayout, i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19008c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19006a.getContext()).inflate(b.a.r0.k2.j.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.f19008c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(b.a.r0.k2.i.iv_pb_video_smart_app_head);
            this.f19009d = headImageView;
            headImageView.setIsRound(true);
            this.f19009d.setPlaceHolder(1);
            this.f19010e = (TextView) this.f19008c.findViewById(b.a.r0.k2.i.tv_pb_video_smart_app_title);
            this.f19011f = (TextView) this.f19008c.findViewById(b.a.r0.k2.i.tv_pb_video_smart_app_abstract);
            this.f19012g = (ImageView) this.f19008c.findViewById(b.a.r0.k2.i.iv_pb_video_smart_app_arrow);
            this.f19008c.setOnClickListener(this.f19007b);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            RelativeLayout relativeLayout = this.f19008c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, b.a.r0.k2.f.CAM_X0204);
            }
            HeadImageView headImageView = this.f19009d;
            if (headImageView != null) {
                headImageView.setSkinType(i2);
            }
            TextView textView = this.f19010e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0105);
            }
            TextView textView2 = this.f19011f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, b.a.r0.k2.f.CAM_X0107);
            }
            ImageView imageView = this.f19012g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, b.a.r0.k2.h.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f19008c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(b.a.r0.k2.r.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, bdTypeListView) == null) || fVar == null || bdTypeListView == null) {
            return;
        }
        if (fVar.O().E2() && fVar.O().e1() != null) {
            SmartApp e1 = fVar.O().e1();
            this.f19008c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!b.a.e.e.p.k.isEmpty(e1.avatar)) {
                this.f19009d.startLoad(e1.avatar, 10, false, false);
            }
            if (!b.a.e.e.p.k.isEmpty(e1.name)) {
                charSequence = e1.name + " " + ((Object) this.f19006a.getText(b.a.r0.k2.l.smart_app_suffix));
            } else {
                charSequence = this.f19006a.getText(b.a.r0.k2.l.intelligent_smart_app).toString();
            }
            this.f19010e.setText(charSequence);
            if (!b.a.e.e.p.k.isEmpty(e1._abstract)) {
                this.f19011f.setText(e1._abstract);
            } else {
                this.f19011f.setText(this.f19006a.getText(b.a.r0.k2.l.smart_app_default_abstract));
            }
            this.f19008c.setTag(e1);
            return;
        }
        this.f19008c.setVisibility(8);
        d(bdTypeListView);
    }
}
