package b.a.r0.x0.b3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.e.a.f;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
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
    public TbImageView f25556a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25557b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f25558c;

    /* renamed from: d  reason: collision with root package name */
    public C1259a f25559d;

    /* renamed from: e  reason: collision with root package name */
    public f f25560e;

    /* renamed from: f  reason: collision with root package name */
    public View f25561f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25562g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25563h;

    /* renamed from: b.a.r0.x0.b3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1259a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f25564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25565f;

        /* renamed from: b.a.r0.x0.b3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1260a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f25566e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1259a f25567f;

            public View$OnClickListenerC1260a(C1259a c1259a, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1259a, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25567f = c1259a;
                this.f25566e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f25567f.getItem(this.f25566e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f25567f.f25565f.f25560e.getContext()).createNormalCfg(this.f25567f.getItem(this.f25566e).forum_name, null)));
            }
        }

        public C1259a(a aVar, List<RecmForumInfo> list) {
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
            this.f25565f = aVar;
            this.f25564e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f25564e.get(i2) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25564e.size() : invokeV.intValue;
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
                    view = LayoutInflater.from(this.f25565f.f25560e.getPageActivity()).inflate(f1.recommend_view, (ViewGroup) null);
                    bVar = new b();
                    bVar.f25573f = view.findViewById(e1.root_view);
                    bVar.f25568a = (TextView) view.findViewById(e1.forum_name);
                    bVar.f25570c = (TextView) view.findViewById(e1.follow_tv);
                    bVar.f25569b = (TextView) view.findViewById(e1.thread_tv);
                    bVar.f25571d = (ImageView) view.findViewById(e1.arrow_item_img);
                    bVar.f25572e = (TbImageView) view.findViewById(e1.headview);
                    bVar.f25574g = (TextView) view.findViewById(e1.follow_title);
                    bVar.f25575h = (TextView) view.findViewById(e1.thread_title);
                    bVar.f25576i = view.findViewById(e1.divider_line);
                    bVar.j = (ImageView) view.findViewById(e1.content_img);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i2) != null) {
                    bVar.f25568a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, "..."));
                    bVar.f25572e.startLoad(getItem(i2).avatar, 10, false);
                    bVar.f25570c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                    bVar.f25569b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                    bVar.f25573f.setOnClickListener(new View$OnClickListenerC1260a(this, i2));
                    SkinManager.setViewTextColor(bVar.f25568a, b1.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f25570c, b1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f25569b, b1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f25575h, b1.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f25574g, b1.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.f25576i, b1.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f25571d, d1.icon_pure_list_arrow16_right_svg, b1.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, d1.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, d1.picture_content_frame);
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
        public TextView f25568a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25569b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25570c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f25571d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f25572e;

        /* renamed from: f  reason: collision with root package name */
        public View f25573f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25574g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25575h;

        /* renamed from: i  reason: collision with root package name */
        public View f25576i;
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
        super(LayoutInflater.from(fVar.getContext()).inflate(f1.forbid_detail_view_layout, (ViewGroup) null));
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
        this.f25560e = fVar;
        this.f25556a = (TbImageView) this.attachedView.findViewById(e1.net_refresh_image);
        this.f25557b = (TextView) this.attachedView.findViewById(e1.net_refresh_desc);
        this.f25561f = this.attachedView.findViewById(e1.divider);
        this.f25558c = (BdListView) this.attachedView.findViewById(e1.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f25562g = (TextView) this.attachedView.findViewById(e1.content_title);
        this.f25563h = (TextView) this.attachedView.findViewById(e1.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        C1259a c1259a = new C1259a(this, list);
        this.f25559d = c1259a;
        this.f25558c.setAdapter((ListAdapter) c1259a);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f25557b.setVisibility(8);
                return;
            }
            this.f25557b.setVisibility(0);
            this.f25557b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f25556a, d1.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f25557b, b1.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, b1.CAM_X0201);
            SkinManager.setBackgroundColor(this.f25561f, b1.CAM_X0204);
            SkinManager.setViewTextColor(this.f25562g, b1.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f25563h, b1.CAM_X0106, 1, skinType);
            C1259a c1259a = this.f25559d;
            if (c1259a != null) {
                c1259a.notifyDataSetChanged();
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
            this.f25556a.setImageResource(0);
        }
    }
}
