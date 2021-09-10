package c.a.r0.w0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.e.a.f;
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
/* loaded from: classes4.dex */
public class a extends c.a.q0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f27695a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27696b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f27697c;

    /* renamed from: d  reason: collision with root package name */
    public C1304a f27698d;

    /* renamed from: e  reason: collision with root package name */
    public f f27699e;

    /* renamed from: f  reason: collision with root package name */
    public View f27700f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27701g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27702h;

    /* renamed from: c.a.r0.w0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1304a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f27703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27704f;

        /* renamed from: c.a.r0.w0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1305a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f27705e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1304a f27706f;

            public View$OnClickListenerC1305a(C1304a c1304a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1304a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27706f = c1304a;
                this.f27705e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f27706f.getItem(this.f27705e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f27706f.f27704f.f27699e.getContext()).createNormalCfg(this.f27706f.getItem(this.f27705e).forum_name, null)));
            }
        }

        public C1304a(a aVar, List<RecmForumInfo> list) {
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
            this.f27704f = aVar;
            this.f27703e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f27703e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27703e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f27704f.f27699e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f27712f = view.findViewById(R.id.root_view);
                    bVar.f27707a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f27709c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f27708b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f27710d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f27711e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f27713g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f27714h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f27715i = view.findViewById(R.id.divider_line);
                    bVar.f27716j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f27707a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f27711e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f27709c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f27708b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f27712f.setOnClickListener(new View$OnClickListenerC1305a(this, i2));
                    SkinManager.setViewTextColor(bVar.f27707a, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f27709c, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27708b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27714h, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27713g, R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f27715i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f27710d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.f27716j, R.drawable.picture_content_frame);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f27707a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f27708b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27709c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f27710d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f27711e;

        /* renamed from: f  reason: collision with root package name */
        public View f27712f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27713g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f27714h;

        /* renamed from: i  reason: collision with root package name */
        public View f27715i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f27716j;

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
        this.f27699e = fVar;
        this.f27695a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f27696b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f27700f = this.attachedView.findViewById(R.id.divider);
        this.f27697c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f27701g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f27702h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1304a c1304a = new C1304a(this, list);
        this.f27698d = c1304a;
        this.f27697c.setAdapter((ListAdapter) c1304a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f27696b.setVisibility(8);
                return;
            }
            this.f27696b.setVisibility(0);
            this.f27696b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f27695a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f27696b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f27700f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f27701g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f27702h, R.color.CAM_X0106, 1, skinType);
            C1304a c1304a = this.f27698d;
            if (c1304a != null) {
                c1304a.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.f27695a.setImageResource(0);
        }
    }
}
