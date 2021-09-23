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
    public TbImageView f27715a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27716b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f27717c;

    /* renamed from: d  reason: collision with root package name */
    public C1302a f27718d;

    /* renamed from: e  reason: collision with root package name */
    public f f27719e;

    /* renamed from: f  reason: collision with root package name */
    public View f27720f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27721g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27722h;

    /* renamed from: c.a.r0.w0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1302a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f27723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27724f;

        /* renamed from: c.a.r0.w0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1303a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f27725e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1302a f27726f;

            public View$OnClickListenerC1303a(C1302a c1302a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1302a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27726f = c1302a;
                this.f27725e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f27726f.getItem(this.f27725e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f27726f.f27724f.f27719e.getContext()).createNormalCfg(this.f27726f.getItem(this.f27725e).forum_name, null)));
            }
        }

        public C1302a(a aVar, List<RecmForumInfo> list) {
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
            this.f27724f = aVar;
            this.f27723e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f27723e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27723e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f27724f.f27719e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f27732f = view.findViewById(R.id.root_view);
                    bVar.f27727a = (TextView) view.findViewById(R.id.forum_name);
                    bVar.f27729c = (TextView) view.findViewById(R.id.follow_tv);
                    bVar.f27728b = (TextView) view.findViewById(R.id.thread_tv);
                    bVar.f27730d = (ImageView) view.findViewById(R.id.arrow_item_img);
                    bVar.f27731e = (TbImageView) view.findViewById(R.id.headview);
                    bVar.f27733g = (TextView) view.findViewById(R.id.follow_title);
                    bVar.f27734h = (TextView) view.findViewById(R.id.thread_title);
                    bVar.f27735i = view.findViewById(R.id.divider_line);
                    bVar.f27736j = (ImageView) view.findViewById(R.id.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f27727a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f27731e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f27729c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f27728b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f27732f.setOnClickListener(new View$OnClickListenerC1303a(this, i2));
                    SkinManager.setViewTextColor(bVar.f27727a, R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f27729c, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27728b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27734h, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f27733g, R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f27735i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f27730d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.f27736j, R.drawable.picture_content_frame);
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
        public TextView f27727a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f27728b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27729c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f27730d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f27731e;

        /* renamed from: f  reason: collision with root package name */
        public View f27732f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27733g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f27734h;

        /* renamed from: i  reason: collision with root package name */
        public View f27735i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f27736j;

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
        this.f27719e = fVar;
        this.f27715a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f27716b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f27720f = this.attachedView.findViewById(R.id.divider);
        this.f27717c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f27721g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f27722h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1302a c1302a = new C1302a(this, list);
        this.f27718d = c1302a;
        this.f27717c.setAdapter((ListAdapter) c1302a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f27716b.setVisibility(8);
                return;
            }
            this.f27716b.setVisibility(0);
            this.f27716b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f27715a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f27716b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f27720f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f27721g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f27722h, R.color.CAM_X0106, 1, skinType);
            C1302a c1302a = this.f27718d;
            if (c1302a != null) {
                c1302a.notifyDataSetChanged();
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
            this.f27715a.setImageResource(0);
        }
    }
}
