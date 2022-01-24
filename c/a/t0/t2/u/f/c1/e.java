package c.a.t0.t2.u.f.c1;

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
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f22963b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22964c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f22965d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22966e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22967f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22968g;

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
        this.f22963b = null;
        this.a = pbFragment;
        this.f22963b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null || (relativeLayout = this.f22964c) == null) {
            return;
        }
        bdTypeListView.addHeaderView(relativeLayout, i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22964c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(c.a.t0.t2.j.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.f22964c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(c.a.t0.t2.i.iv_pb_video_smart_app_head);
            this.f22965d = headImageView;
            headImageView.setIsRound(true);
            this.f22965d.setPlaceHolder(1);
            this.f22966e = (TextView) this.f22964c.findViewById(c.a.t0.t2.i.tv_pb_video_smart_app_title);
            this.f22967f = (TextView) this.f22964c.findViewById(c.a.t0.t2.i.tv_pb_video_smart_app_abstract);
            this.f22968g = (ImageView) this.f22964c.findViewById(c.a.t0.t2.i.iv_pb_video_smart_app_arrow);
            this.f22964c.setOnClickListener(this.f22963b);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            RelativeLayout relativeLayout = this.f22964c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, c.a.t0.t2.f.CAM_X0204);
            }
            HeadImageView headImageView = this.f22965d;
            if (headImageView != null) {
                headImageView.setSkinType(i2);
            }
            TextView textView = this.f22966e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c.a.t0.t2.f.CAM_X0105);
            }
            TextView textView2 = this.f22967f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, c.a.t0.t2.f.CAM_X0107);
            }
            ImageView imageView = this.f22968g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, c.a.t0.t2.h.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f22964c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(c.a.t0.t2.r.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, bdTypeListView) == null) || fVar == null || bdTypeListView == null) {
            return;
        }
        if (fVar.O().I2() && fVar.O().h1() != null) {
            SmartApp h1 = fVar.O().h1();
            this.f22964c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!m.isEmpty(h1.avatar)) {
                this.f22965d.startLoad(h1.avatar, 10, false, false);
            }
            if (!m.isEmpty(h1.name)) {
                charSequence = h1.name + " " + ((Object) this.a.getText(c.a.t0.t2.l.smart_app_suffix));
            } else {
                charSequence = this.a.getText(c.a.t0.t2.l.intelligent_smart_app).toString();
            }
            this.f22966e.setText(charSequence);
            if (!m.isEmpty(h1._abstract)) {
                this.f22967f.setText(h1._abstract);
            } else {
                this.f22967f.setText(this.a.getText(c.a.t0.t2.l.smart_app_default_abstract));
            }
            this.f22964c.setTag(h1);
            return;
        }
        this.f22964c.setVisibility(8);
        d(bdTypeListView);
    }
}
