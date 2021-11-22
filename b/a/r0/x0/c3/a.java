package b.a.r0.x0.c3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.e.a.f;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
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
/* loaded from: classes5.dex */
public class a extends b.a.q0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f27144a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27145b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f27146c;

    /* renamed from: d  reason: collision with root package name */
    public C1332a f27147d;

    /* renamed from: e  reason: collision with root package name */
    public f f27148e;

    /* renamed from: f  reason: collision with root package name */
    public View f27149f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27150g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27151h;

    /* renamed from: b.a.r0.x0.c3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1332a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f27152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27153f;

        /* renamed from: b.a.r0.x0.c3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1333a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f27154e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1332a f27155f;

            public View$OnClickListenerC1333a(C1332a c1332a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1332a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27155f = c1332a;
                this.f27154e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f27155f.getItem(this.f27154e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f27155f.f27153f.f27148e.getContext()).createNormalCfg(this.f27155f.getItem(this.f27154e).forum_name, null)));
            }
        }

        public C1332a(a aVar, List<RecmForumInfo> list) {
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
            this.f27153f = aVar;
            this.f27152e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f27152e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27152e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f27153f.f27148e.getPageActivity()).inflate(g1.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f27161f = view.findViewById(f1.root_view);
                    bVar.f27156a = (TextView) view.findViewById(f1.forum_name);
                    bVar.f27158c = (TextView) view.findViewById(f1.follow_tv);
                    bVar.f27157b = (TextView) view.findViewById(f1.thread_tv);
                    bVar.f27159d = (ImageView) view.findViewById(f1.arrow_item_img);
                    bVar.f27160e = (TbImageView) view.findViewById(f1.headview);
                    bVar.f27162g = (TextView) view.findViewById(f1.follow_title);
                    bVar.f27163h = (TextView) view.findViewById(f1.thread_title);
                    bVar.f27164i = view.findViewById(f1.divider_line);
                    bVar.j = (ImageView) view.findViewById(f1.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f27156a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f27160e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f27158c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f27157b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f27161f.setOnClickListener(new View$OnClickListenerC1333a(this, i2));
                    SkinManager.setViewTextColor(bVar.f27156a, c1.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f27158c, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27157b, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27163h, c1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27162g, c1.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f27164i, c1.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f27159d, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, e1.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, e1.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f27156a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f27157b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27158c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f27159d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f27160e;

        /* renamed from: f  reason: collision with root package name */
        public View f27161f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27162g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f27163h;

        /* renamed from: i  reason: collision with root package name */
        public View f27164i;
        public ImageView j;

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
        this.f27148e = fVar;
        this.f27144a = (TbImageView) this.attachedView.findViewById(f1.net_refresh_image);
        this.f27145b = (TextView) this.attachedView.findViewById(f1.net_refresh_desc);
        this.f27149f = this.attachedView.findViewById(f1.divider);
        this.f27146c = (BdListView) this.attachedView.findViewById(f1.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f27150g = (TextView) this.attachedView.findViewById(f1.content_title);
        this.f27151h = (TextView) this.attachedView.findViewById(f1.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1332a c1332a = new C1332a(this, list);
        this.f27147d = c1332a;
        this.f27146c.setAdapter((ListAdapter) c1332a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f27145b.setVisibility(8);
                return;
            }
            this.f27145b.setVisibility(0);
            this.f27145b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f27144a, e1.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f27145b, c1.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.f27149f, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.f27150g, c1.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f27151h, c1.CAM_X0106, 1, skinType);
            C1332a c1332a = this.f27147d;
            if (c1332a != null) {
                c1332a.notifyDataSetChanged();
            }
        }
    }

    @Override // b.a.q0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // b.a.q0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.f27144a.setImageResource(0);
        }
    }
}
