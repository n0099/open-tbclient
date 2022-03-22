package c.a.p0.f1.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
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
public class c extends c.a.o0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14753b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f14754c;

    /* renamed from: d  reason: collision with root package name */
    public a f14755d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.a.f f14756e;

    /* renamed from: f  reason: collision with root package name */
    public View f14757f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14758g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14759h;

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<RecmForumInfo> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14760b;

        /* renamed from: c.a.p0.f1.v2.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1116a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f14761b;

            public View$OnClickListenerC1116a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14761b = aVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f14761b.getItem(this.a).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f14761b.f14760b.f14756e.getContext()).createNormalCfg(this.f14761b.getItem(this.a).forum_name, null)));
            }
        }

        public a(c cVar, List<RecmForumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14760b = cVar;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a.get(i) : (RecmForumInfo) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f14760b.f14756e.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0730, (ViewGroup) null);
                    bVar = new b();
                    bVar.f14766f = view.findViewById(R.id.obfuscated_res_0x7f091aee);
                    bVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a67);
                    bVar.f14763c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a04);
                    bVar.f14762b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091fce);
                    bVar.f14764d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0902a7);
                    bVar.f14765e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090d4b);
                    bVar.f14767g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a03);
                    bVar.f14768h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091fcd);
                    bVar.i = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
                    bVar.j = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0906e1);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (getItem(i) != null) {
                    bVar.a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                    bVar.f14765e.J(getItem(i).avatar, 10, false);
                    bVar.f14763c.setText(StringHelper.numberUniformFormat(getItem(i).member_count.intValue()));
                    bVar.f14762b.setText(StringHelper.numberUniformFormat(getItem(i).post_num.intValue()));
                    bVar.f14766f.setOnClickListener(new View$OnClickListenerC1116a(this, i));
                    SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0105);
                    SkinManager.setViewTextColor(bVar.f14763c, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f14762b, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f14768h, (int) R.color.CAM_X0109);
                    SkinManager.setViewTextColor(bVar.f14767g, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundResource(bVar.i, R.color.CAM_X0204);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f14764d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                    SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                    SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
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
        public TextView f14762b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14763c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f14764d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f14765e;

        /* renamed from: f  reason: collision with root package name */
        public View f14766f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14767g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14768h;
        public View i;
        public ImageView j;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.d.a.f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.obfuscated_res_0x7f0d02a2, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14756e = fVar;
        this.a = (TbImageView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09153b);
        this.f14753b = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09153a);
        this.f14757f = this.attachedView.findViewById(R.id.obfuscated_res_0x7f0907e1);
        this.f14754c = (BdListView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0919f7);
        this.attachedView.setOnClickListener(null);
        this.f14758g = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0906e8);
        this.f14759h = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091326);
    }

    public void b(List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        a aVar = new a(this, list);
        this.f14755d = aVar;
        this.f14754c.setAdapter((ListAdapter) aVar);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null) {
                this.f14753b.setVisibility(8);
                return;
            }
            this.f14753b.setVisibility(0);
            this.f14753b.setText(str);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f14753b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f14757f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f14758g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f14759h, R.color.CAM_X0106, 1, skinType);
            a aVar = this.f14755d;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.o0.f0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.o0.f0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }
}
