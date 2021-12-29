package c.a.t0.d1.c3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.t0.d1.c1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
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
    public TextView f16246b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f16247c;

    /* renamed from: d  reason: collision with root package name */
    public C1002a f16248d;

    /* renamed from: e  reason: collision with root package name */
    public f f16249e;

    /* renamed from: f  reason: collision with root package name */
    public View f16250f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16251g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16252h;

    /* renamed from: c.a.t0.d1.c3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1002a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f16253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16254f;

        /* renamed from: c.a.t0.d1.c3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1003a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f16255e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1002a f16256f;

            public View$OnClickListenerC1003a(C1002a c1002a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1002a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16256f = c1002a;
                this.f16255e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f16256f.getItem(this.f16255e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16256f.f16254f.f16249e.getContext()).createNormalCfg(this.f16256f.getItem(this.f16255e).forum_name, null)));
            }
        }

        public C1002a(a aVar, List<RecmForumInfo> list) {
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
            this.f16254f = aVar;
            this.f16253e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f16253e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16253e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f16254f.f16249e.getPageActivity()).inflate(g1.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f16261f = view.findViewById(f1.root_view);
                    bVar.a = (TextView) view.findViewById(f1.forum_name);
                    bVar.f16258c = (TextView) view.findViewById(f1.follow_tv);
                    bVar.f16257b = (TextView) view.findViewById(f1.thread_tv);
                    bVar.f16259d = (ImageView) view.findViewById(f1.arrow_item_img);
                    bVar.f16260e = (TbImageView) view.findViewById(f1.headview);
                    bVar.f16262g = (TextView) view.findViewById(f1.follow_title);
                    bVar.f16263h = (TextView) view.findViewById(f1.thread_title);
                    bVar.f16264i = view.findViewById(f1.divider_line);
                    bVar.f16265j = (ImageView) view.findViewById(f1.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f16260e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f16258c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f16257b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f16261f.setOnClickListener(new View$OnClickListenerC1003a(this, i2));
                    SkinManager.setViewTextColor(bVar.a, c1.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f16258c, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16257b, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16263h, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f16262g, c1.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f16264i, c1.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f16259d, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, e1.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.f16265j, e1.picture_content_frame);
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
        public TextView f16257b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16258c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f16259d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16260e;

        /* renamed from: f  reason: collision with root package name */
        public View f16261f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16262g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f16263h;

        /* renamed from: i  reason: collision with root package name */
        public View f16264i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f16265j;

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
        this.f16249e = fVar;
        this.a = (TbImageView) this.attachedView.findViewById(f1.net_refresh_image);
        this.f16246b = (TextView) this.attachedView.findViewById(f1.net_refresh_desc);
        this.f16250f = this.attachedView.findViewById(f1.divider);
        this.f16247c = (BdListView) this.attachedView.findViewById(f1.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f16251g = (TextView) this.attachedView.findViewById(f1.content_title);
        this.f16252h = (TextView) this.attachedView.findViewById(f1.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1002a c1002a = new C1002a(this, list);
        this.f16248d = c1002a;
        this.f16247c.setAdapter((ListAdapter) c1002a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f16246b.setVisibility(8);
                return;
            }
            this.f16246b.setVisibility(0);
            this.f16246b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, e1.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f16246b, c1.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.f16250f, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.f16251g, c1.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f16252h, c1.CAM_X0106, 1, skinType);
            C1002a c1002a = this.f16248d;
            if (c1002a != null) {
                c1002a.notifyDataSetChanged();
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
