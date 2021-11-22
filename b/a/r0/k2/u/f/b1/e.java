package b.a.r0.k2.u.f.b1;

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
    public PbFragment f20585a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f20586b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20587c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f20588d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20589e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20590f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20591g;

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
        this.f20586b = null;
        this.f20585a = pbFragment;
        this.f20586b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null || (relativeLayout = this.f20587c) == null) {
            return;
        }
        bdTypeListView.addHeaderView(relativeLayout, i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f20587c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f20585a.getContext()).inflate(b.a.r0.k2.j.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.f20587c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(b.a.r0.k2.i.iv_pb_video_smart_app_head);
            this.f20588d = headImageView;
            headImageView.setIsRound(true);
            this.f20588d.setPlaceHolder(1);
            this.f20589e = (TextView) this.f20587c.findViewById(b.a.r0.k2.i.tv_pb_video_smart_app_title);
            this.f20590f = (TextView) this.f20587c.findViewById(b.a.r0.k2.i.tv_pb_video_smart_app_abstract);
            this.f20591g = (ImageView) this.f20587c.findViewById(b.a.r0.k2.i.iv_pb_video_smart_app_arrow);
            this.f20587c.setOnClickListener(this.f20586b);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            RelativeLayout relativeLayout = this.f20587c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, b.a.r0.k2.f.CAM_X0204);
            }
            HeadImageView headImageView = this.f20588d;
            if (headImageView != null) {
                headImageView.setSkinType(i2);
            }
            TextView textView = this.f20589e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0105);
            }
            TextView textView2 = this.f20590f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, b.a.r0.k2.f.CAM_X0107);
            }
            ImageView imageView = this.f20591g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, b.a.r0.k2.h.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f20587c) == null) {
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
        if (fVar.O().G2() && fVar.O().f1() != null) {
            SmartApp f1 = fVar.O().f1();
            this.f20587c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!b.a.e.f.p.k.isEmpty(f1.avatar)) {
                this.f20588d.startLoad(f1.avatar, 10, false, false);
            }
            if (!b.a.e.f.p.k.isEmpty(f1.name)) {
                charSequence = f1.name + " " + ((Object) this.f20585a.getText(b.a.r0.k2.l.smart_app_suffix));
            } else {
                charSequence = this.f20585a.getText(b.a.r0.k2.l.intelligent_smart_app).toString();
            }
            this.f20589e.setText(charSequence);
            if (!b.a.e.f.p.k.isEmpty(f1._abstract)) {
                this.f20590f.setText(f1._abstract);
            } else {
                this.f20590f.setText(this.f20585a.getText(b.a.r0.k2.l.smart_app_default_abstract));
            }
            this.f20587c.setTag(f1);
            return;
        }
        this.f20587c.setVisibility(8);
        d(bdTypeListView);
    }
}
