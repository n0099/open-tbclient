package c.a.r0.d1.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class a extends c.a.q0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16582b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f16583c;

    /* renamed from: d  reason: collision with root package name */
    public C1057a f16584d;

    /* renamed from: e  reason: collision with root package name */
    public f f16585e;

    /* renamed from: f  reason: collision with root package name */
    public View f16586f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16587g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16588h;

    /* renamed from: c.a.r0.d1.v2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1057a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f16589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16590f;

        /* renamed from: c.a.r0.d1.v2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1058a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f16591e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1057a f16592f;

            public View$OnClickListenerC1058a(C1057a c1057a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1057a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16592f = c1057a;
                this.f16591e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f16592f.getItem(this.f16591e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16592f.f16590f.f16585e.getContext()).createNormalCfg(this.f16592f.getItem(this.f16591e).forum_name, null)));
            }
        }

        public C1057a(a aVar, List<RecmForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16590f = aVar;
            this.f16589e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f16589e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16589e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f16590f.f16585e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f16597f = view.findViewById(R.id.root_view);
                    bVar.a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f16594c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f16593b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f16595d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f16596e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f16598g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f16599h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f16600i = view.findViewById(R.id.divider_line);
                    bVar.f16601j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f16596e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f16594c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f16593b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f16597f.setOnClickListener(new View$OnClickListenerC1058a(this, i2));
                    SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f16594c, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16593b, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16599h, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16598g, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f16600i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16595d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.f16601j, R.drawable.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16593b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16594c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16595d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16596e;

        /* renamed from: f  reason: collision with root package name */
        public View f16597f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16598g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f16599h;

        /* renamed from: i  reason: collision with root package name */
        public View f16600i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f16601j;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16585e = fVar;
        this.a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f16582b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f16586f = this.attachedView.findViewById(R.id.divider);
        this.f16583c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f16587g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f16588h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1057a c1057a = new C1057a(this, list);
        this.f16584d = c1057a;
        this.f16583c.setAdapter((ListAdapter) c1057a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f16582b.setVisibility(8);
                return;
            }
            this.f16582b.setVisibility(0);
            this.f16582b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f16582b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f16586f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f16587g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f16588h, R.color.CAM_X0106, 1, skinType);
            C1057a c1057a = this.f16584d;
            if (c1057a != null) {
                c1057a.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.q0.f0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.q0.f0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }
}
