package c.a.s0.s2.u.f.b1;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f22795b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22796c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f22797d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22798e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22799f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22800g;

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
        this.f22795b = null;
        this.a = pbFragment;
        this.f22795b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null || (relativeLayout = this.f22796c) == null) {
            return;
        }
        bdTypeListView.addHeaderView(relativeLayout, i2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22796c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(c.a.s0.s2.j.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.f22796c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(c.a.s0.s2.i.iv_pb_video_smart_app_head);
            this.f22797d = headImageView;
            headImageView.setIsRound(true);
            this.f22797d.setPlaceHolder(1);
            this.f22798e = (TextView) this.f22796c.findViewById(c.a.s0.s2.i.tv_pb_video_smart_app_title);
            this.f22799f = (TextView) this.f22796c.findViewById(c.a.s0.s2.i.tv_pb_video_smart_app_abstract);
            this.f22800g = (ImageView) this.f22796c.findViewById(c.a.s0.s2.i.iv_pb_video_smart_app_arrow);
            this.f22796c.setOnClickListener(this.f22795b);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            RelativeLayout relativeLayout = this.f22796c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, c.a.s0.s2.f.CAM_X0204);
            }
            HeadImageView headImageView = this.f22797d;
            if (headImageView != null) {
                headImageView.setSkinType(i2);
            }
            TextView textView = this.f22798e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c.a.s0.s2.f.CAM_X0105);
            }
            TextView textView2 = this.f22799f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, c.a.s0.s2.f.CAM_X0107);
            }
            ImageView imageView = this.f22800g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, c.a.s0.s2.h.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.f22796c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(c.a.s0.s2.r.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, fVar, bdTypeListView) == null) || fVar == null || bdTypeListView == null) {
            return;
        }
        if (fVar.O().H2() && fVar.O().g1() != null) {
            SmartApp g1 = fVar.O().g1();
            this.f22796c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!c.a.d.f.p.l.isEmpty(g1.avatar)) {
                this.f22797d.startLoad(g1.avatar, 10, false, false);
            }
            if (!c.a.d.f.p.l.isEmpty(g1.name)) {
                charSequence = g1.name + " " + ((Object) this.a.getText(c.a.s0.s2.l.smart_app_suffix));
            } else {
                charSequence = this.a.getText(c.a.s0.s2.l.intelligent_smart_app).toString();
            }
            this.f22798e.setText(charSequence);
            if (!c.a.d.f.p.l.isEmpty(g1._abstract)) {
                this.f22799f.setText(g1._abstract);
            } else {
                this.f22799f.setText(this.a.getText(c.a.s0.s2.l.smart_app_default_abstract));
            }
            this.f22796c.setTag(g1);
            return;
        }
        this.f22796c.setVisibility(8);
        d(bdTypeListView);
    }
}
