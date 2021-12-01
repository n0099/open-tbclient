package c.a.r0.e2.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.r0.e2.c.k.r;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoNetworkView a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f16916b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f16917c;

    /* renamed from: d  reason: collision with root package name */
    public View f16918d;

    /* renamed from: e  reason: collision with root package name */
    public b f16919e;

    /* renamed from: f  reason: collision with root package name */
    public View f16920f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16921g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16922h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f16923i;

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
        this.f16923i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f16918d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f16916b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16916b.setTitleText(R.string.member_task_center);
        this.f16917c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f16920f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f16917c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f16920f.findViewById(R.id.advert_image_view);
        this.f16921g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f16922h = (TextView) this.f16920f.findViewById(R.id.current_score_num);
        this.f16921g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f16919e = bVar;
        bVar.d(onClickListener);
        this.f16917c.addHeaderView(this.f16920f);
        this.f16917c.setAdapter((ListAdapter) this.f16919e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16917c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16918d : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f16916b.onChangeSkinType(this.f16923i.getPageContext(), i2);
            this.a.onChangeSkinType(this.f16923i.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f16922h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j2)}) == null) {
            this.f16921g.startLoad(str, 10, false);
            this.f16922h.setText(a(this.f16923i.getResources().getString(R.string.current_score), String.valueOf(j2)));
            this.f16919e.c(list);
            this.f16919e.notifyDataSetChanged();
        }
    }
}
