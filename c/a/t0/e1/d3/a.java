package c.a.t0.e1.d3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.t0.e1.c1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes7.dex */
public class a extends c.a.s0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16293b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f16294c;

    /* renamed from: d  reason: collision with root package name */
    public C1039a f16295d;

    /* renamed from: e  reason: collision with root package name */
    public f f16296e;

    /* renamed from: f  reason: collision with root package name */
    public View f16297f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16298g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16299h;

    /* renamed from: c.a.t0.e1.d3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1039a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f16300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16301f;

        /* renamed from: c.a.t0.e1.d3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1040a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f16302e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1039a f16303f;

            public View$OnClickListenerC1040a(C1039a c1039a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1039a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16303f = c1039a;
                this.f16302e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f16303f.getItem(this.f16302e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16303f.f16301f.f16296e.getContext()).createNormalCfg(this.f16303f.getItem(this.f16302e).forum_name, null)));
            }
        }

        public C1039a(a aVar, List<RecmForumInfo> list) {
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
            this.f16301f = aVar;
            this.f16300e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f16300e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16300e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f16301f.f16296e.getPageActivity()).inflate(g1.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f16308f = view.findViewById(f1.root_view);
                    bVar.a = (TextView) view.findViewById(f1.forum_name);
                    bVar.f16305c = (TextView) view.findViewById(f1.follow_tv);
                    bVar.f16304b = (TextView) view.findViewById(f1.thread_tv);
                    bVar.f16306d = (ImageView) view.findViewById(f1.arrow_item_img);
                    bVar.f16307e = (TbImageView) view.findViewById(f1.headview);
                    bVar.f16309g = (TextView) view.findViewById(f1.follow_title);
                    bVar.f16310h = (TextView) view.findViewById(f1.thread_title);
                    bVar.f16311i = view.findViewById(f1.divider_line);
                    bVar.f16312j = (ImageView) view.findViewById(f1.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f16307e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f16305c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f16304b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f16308f.setOnClickListener(new View$OnClickListenerC1040a(this, i2));
                    SkinManager.setViewTextColor(bVar.a, c1.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f16305c, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16304b, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16310h, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16309g, c1.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f16311i, c1.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16306d, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, e1.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.f16312j, e1.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16304b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16305c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16306d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16307e;

        /* renamed from: f  reason: collision with root package name */
        public View f16308f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16309g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f16310h;

        /* renamed from: i  reason: collision with root package name */
        public View f16311i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f16312j;

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
        super(LayoutInflater.from(fVar.getContext()).inflate(g1.forbid_detail_view_layout, (ViewGroup) null));
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
        this.f16296e = fVar;
        this.a = (TbImageView) this.attachedView.findViewById(f1.net_refresh_image);
        this.f16293b = (TextView) this.attachedView.findViewById(f1.net_refresh_desc);
        this.f16297f = this.attachedView.findViewById(f1.divider);
        this.f16294c = (BdListView) this.attachedView.findViewById(f1.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f16298g = (TextView) this.attachedView.findViewById(f1.content_title);
        this.f16299h = (TextView) this.attachedView.findViewById(f1.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1039a c1039a = new C1039a(this, list);
        this.f16295d = c1039a;
        this.f16294c.setAdapter((ListAdapter) c1039a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f16293b.setVisibility(8);
                return;
            }
            this.f16293b.setVisibility(0);
            this.f16293b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, e1.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f16293b, c1.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.f16297f, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.f16298g, c1.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f16299h, c1.CAM_X0106, 1, skinType);
            C1039a c1039a = this.f16295d;
            if (c1039a != null) {
                c1039a.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.s0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.s0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }
}
