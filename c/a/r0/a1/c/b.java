package c.a.r0.a1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.r0.a1.b.g;
import c.a.r0.a1.c.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15775e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C0751a> f15776f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f15777g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15778h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f15779i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15780j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15781e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15781e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f15781e.f15777g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f15781e.f15777g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.r0.a1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0752b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15782a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15783b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f15784c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15785d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15786e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15787f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15788g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15789h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f15790i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f15791j;
        public TextView k;

        public C0752b() {
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

        public /* synthetic */ C0752b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15775e = 1;
        this.f15778h = false;
        this.k = -1;
        this.l = new a(this);
        this.f15777g = myGiftListActivity;
        this.f15780j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f15777g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f15777g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f15777g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f15777g.getResources().getString(R.string.send_gift), this.f15777g.getSendGiftClickListener()));
            this.f15777g.getResources().getDimension(R.dimen.tbds200);
            this.f15777g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f15777g.getUserSex();
            this.f15777g.getPageContext().getString(R.string.no_gift);
            String string = this.f15777g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f15777g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f15777g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f15780j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f15780j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f15779i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f15777g.getLayoutMode().k(skinType == 1);
            this.f15777g.getLayoutMode().j(inflate);
            this.f15779i.onChangeSkinType(this.f15777g.getPageContext(), skinType);
            this.f15779i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C0751a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f15778h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C0751a> list = this.f15776f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f15776f.size()) {
                return null;
            }
            return this.f15776f.get(itemId);
        }
        return (a.C0751a) invokeI.objValue;
    }

    public void e(List<a.C0751a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f15778h = false;
            } else {
                this.f15778h = true;
            }
            this.f15776f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f15778h) {
                return 1;
            }
            List<a.C0751a> list = this.f15776f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f15776f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0752b c0752b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f15778h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c0752b = (C0752b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f15777g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c0752b = new C0752b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c0752b.f15782a = tbImageView;
                tbImageView.setRadius(l.e(this.f15777g.getBaseContext(), 25.0f));
                c0752b.f15783b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c0752b.f15784c = headImageView;
                headImageView.setRadius(l.e(this.f15777g.getBaseContext(), 50.0f));
                c0752b.f15784c.setOnClickListener(this.l);
                c0752b.f15784c.setPlaceHolder(1);
                c0752b.f15785d = (TextView) view.findViewById(R.id.user_name);
                c0752b.f15789h = (TextView) view.findViewById(R.id.gift_num);
                c0752b.f15788g = (TextView) view.findViewById(R.id.gift_value_text);
                c0752b.f15787f = (TextView) view.findViewById(R.id.gift_name);
                c0752b.f15786e = (TextView) view.findViewById(R.id.time);
                c0752b.f15790i = (TextView) view.findViewById(R.id.paly_icon);
                c0752b.f15791j = (TextView) view.findViewById(R.id.reward_prefix);
                c0752b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c0752b);
            }
            if (!this.f15780j) {
                c0752b.f15786e.setVisibility(8);
                c0752b.f15790i.setVisibility(8);
            } else {
                c0752b.f15790i.setVisibility(0);
            }
            a.C0751a item = getItem(i2);
            if (item != null) {
                if (this.f15777g.userType == 1) {
                    c0752b.f15784c.startLoad(item.f15762c, 12, false);
                    int i3 = item.f15769j;
                    if (i3 == 1) {
                        c0752b.f15782a.setVisibility(0);
                        c0752b.f15782a.setImageResource(R.drawable.icon_frs_no1);
                        c0752b.f15783b.setVisibility(8);
                    } else if (i3 == 2) {
                        c0752b.f15782a.setVisibility(0);
                        c0752b.f15782a.setImageResource(R.drawable.icon_frs_no2);
                        c0752b.f15783b.setVisibility(8);
                    } else if (i3 == 3) {
                        c0752b.f15782a.setVisibility(0);
                        c0752b.f15782a.setImageResource(R.drawable.icon_frs_no3);
                        c0752b.f15783b.setVisibility(8);
                    } else {
                        c0752b.f15782a.setVisibility(8);
                        c0752b.f15783b.setVisibility(0);
                        TextView textView = c0752b.f15783b;
                        textView.setText(item.f15769j + "");
                    }
                } else {
                    c0752b.f15784c.startLoad(item.f15763d, 10, false);
                    c0752b.f15782a.setVisibility(8);
                    c0752b.f15783b.setVisibility(8);
                }
                c0752b.f15784c.setDrawBorder(false);
                c0752b.f15785d.setText(TextUtils.isEmpty(item.k) ? item.f15761b : item.k);
                c0752b.f15784c.setTag(R.id.tag_first, Long.valueOf(item.f15760a));
                c0752b.f15784c.setTag(R.id.tag_second, item.f15761b);
                c0752b.f15787f.setText(this.f15777g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c0752b.f15788g;
                textView2.setText(this.f15777g.getPageContext().getString(R.string.gift_value) + item.f15766g);
                if (item.f15765f < 1) {
                    c0752b.f15789h.setVisibility(8);
                } else {
                    TextView textView3 = c0752b.f15789h;
                    textView3.setText(this.f15777g.getPageContext().getString(R.string.mutil_sign) + item.f15765f);
                    c0752b.f15789h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f15764e * 1000);
                c0752b.f15786e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c0752b.f15786e.setVisibility(8);
                    c0752b.f15788g.setText(formatTime);
                    SkinManager.setViewTextColor(c0752b.f15788g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c0752b.f15788g, R.color.CAM_X0301, 1);
                }
                c0752b.f15791j.setVisibility(0);
                c0752b.k.setVisibility(0);
                if (item.f15767h > 0) {
                    if (Integer.parseInt(item.f15768i) == 1) {
                        c0752b.k.setText(g.a(item.f15767h, 1, this.k));
                    } else if (Integer.parseInt(item.f15768i) == 2) {
                        c0752b.k.setText(g.a(item.f15767h, 2, this.k));
                    } else {
                        c0752b.f15791j.setVisibility(8);
                        c0752b.k.setVisibility(8);
                    }
                } else {
                    c0752b.f15791j.setVisibility(8);
                    c0752b.k.setVisibility(8);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15775e : invokeV.intValue;
    }
}
