package c.a.t0.f2.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.t0.f2.c.k.r;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17548b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f17549c;

    /* renamed from: d  reason: collision with root package name */
    public View f17550d;

    /* renamed from: e  reason: collision with root package name */
    public b f17551e;

    /* renamed from: f  reason: collision with root package name */
    public View f17552f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17553g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17554h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f17555i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17555i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f17550d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f17548b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17548b.setTitleText(R.string.member_task_center);
        this.f17549c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f17552f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f17549c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f17552f.findViewById(R.id.advert_image_view);
        this.f17553g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f17554h = (TextView) this.f17552f.findViewById(R.id.current_score_num);
        this.f17553g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f17551e = bVar;
        bVar.d(onClickListener);
        this.f17549c.addHeaderView(this.f17552f);
        this.f17549c.setAdapter((ListAdapter) this.f17551e);
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public BdListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17549c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17550d : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f17548b.onChangeSkinType(this.f17555i.getPageContext(), i2);
            this.a.onChangeSkinType(this.f17555i.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f17554h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j2)}) == null) {
            this.f17553g.startLoad(str, 10, false);
            this.f17554h.setText(a(this.f17555i.getResources().getString(R.string.current_score), String.valueOf(j2)));
            this.f17551e.c(list);
            this.f17551e.notifyDataSetChanged();
        }
    }
}
