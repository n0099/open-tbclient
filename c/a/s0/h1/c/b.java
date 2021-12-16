package c.a.s0.h1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.s0.h1.b.g;
import c.a.s0.h1.c.a;
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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18005e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1086a> f18006f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f18007g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18008h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18009i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18010j;

    /* renamed from: k  reason: collision with root package name */
    public int f18011k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18012e;

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
            this.f18012e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    this.f18012e.f18007g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f18012e.f18007g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.s0.h1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1087b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18013b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f18014c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18015d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18016e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18017f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18018g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18019h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18020i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f18021j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f18022k;

        public C1087b() {
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

        public /* synthetic */ C1087b(a aVar) {
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
        this.f18005e = 1;
        this.f18008h = false;
        this.f18011k = -1;
        this.l = new a(this);
        this.f18007g = myGiftListActivity;
        this.f18010j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f18007g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f18007g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f18007g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f18007g.getResources().getString(R.string.send_gift), this.f18007g.getSendGiftClickListener()));
            this.f18007g.getResources().getDimension(R.dimen.tbds200);
            this.f18007g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f18007g.getUserSex();
            this.f18007g.getPageContext().getString(R.string.no_gift);
            String string = this.f18007g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f18007g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f18007g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f18010j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f18010j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f18009i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f18007g.getLayoutMode().k(skinType == 1);
            this.f18007g.getLayoutMode().j(inflate);
            this.f18009i.onChangeSkinType(this.f18007g.getPageContext(), skinType);
            this.f18009i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1086a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f18008h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1086a> list = this.f18006f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f18006f.size()) {
                return null;
            }
            return this.f18006f.get(itemId);
        }
        return (a.C1086a) invokeI.objValue;
    }

    public void e(List<a.C1086a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f18008h = false;
            } else {
                this.f18008h = true;
            }
            this.f18006f = list;
            this.f18011k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f18008h) {
                return 1;
            }
            List<a.C1086a> list = this.f18006f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f18006f.size();
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
        C1087b c1087b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f18008h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1087b = (C1087b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f18007g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1087b = new C1087b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1087b.a = tbImageView;
                tbImageView.setRadius(m.d(this.f18007g.getBaseContext(), 25.0f));
                c1087b.f18013b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1087b.f18014c = headImageView;
                headImageView.setRadius(m.d(this.f18007g.getBaseContext(), 50.0f));
                c1087b.f18014c.setOnClickListener(this.l);
                c1087b.f18014c.setPlaceHolder(1);
                c1087b.f18015d = (TextView) view.findViewById(R.id.user_name);
                c1087b.f18019h = (TextView) view.findViewById(R.id.gift_num);
                c1087b.f18018g = (TextView) view.findViewById(R.id.gift_value_text);
                c1087b.f18017f = (TextView) view.findViewById(R.id.gift_name);
                c1087b.f18016e = (TextView) view.findViewById(R.id.time);
                c1087b.f18020i = (TextView) view.findViewById(R.id.paly_icon);
                c1087b.f18021j = (TextView) view.findViewById(R.id.reward_prefix);
                c1087b.f18022k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1087b);
            }
            if (!this.f18010j) {
                c1087b.f18016e.setVisibility(8);
                c1087b.f18020i.setVisibility(8);
            } else {
                c1087b.f18020i.setVisibility(0);
            }
            a.C1086a item = getItem(i2);
            if (item != null) {
                if (this.f18007g.userType == 1) {
                    c1087b.f18014c.startLoad(item.f17993c, 12, false);
                    int i3 = item.f18000j;
                    if (i3 == 1) {
                        c1087b.a.setVisibility(0);
                        c1087b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1087b.f18013b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1087b.a.setVisibility(0);
                        c1087b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1087b.f18013b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1087b.a.setVisibility(0);
                        c1087b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1087b.f18013b.setVisibility(8);
                    } else {
                        c1087b.a.setVisibility(8);
                        c1087b.f18013b.setVisibility(0);
                        TextView textView = c1087b.f18013b;
                        textView.setText(item.f18000j + "");
                    }
                } else {
                    c1087b.f18014c.startLoad(item.f17994d, 10, false);
                    c1087b.a.setVisibility(8);
                    c1087b.f18013b.setVisibility(8);
                }
                c1087b.f18014c.setDrawBorder(false);
                c1087b.f18015d.setText(TextUtils.isEmpty(item.f18001k) ? item.f17992b : item.f18001k);
                c1087b.f18014c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1087b.f18014c.setTag(R.id.tag_second, item.f17992b);
                c1087b.f18017f.setText(this.f18007g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1087b.f18018g;
                textView2.setText(this.f18007g.getPageContext().getString(R.string.gift_value) + item.f17997g);
                if (item.f17996f < 1) {
                    c1087b.f18019h.setVisibility(8);
                } else {
                    TextView textView3 = c1087b.f18019h;
                    textView3.setText(this.f18007g.getPageContext().getString(R.string.mutil_sign) + item.f17996f);
                    c1087b.f18019h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f17995e * 1000);
                c1087b.f18016e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.f18011k)) {
                    c1087b.f18016e.setVisibility(8);
                    c1087b.f18018g.setText(formatTime);
                    SkinManager.setViewTextColor(c1087b.f18018g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1087b.f18018g, R.color.CAM_X0301, 1);
                }
                c1087b.f18021j.setVisibility(0);
                c1087b.f18022k.setVisibility(0);
                if (item.f17998h > 0) {
                    if (Integer.parseInt(item.f17999i) == 1) {
                        c1087b.f18022k.setText(g.a(item.f17998h, 1, this.f18011k));
                    } else if (Integer.parseInt(item.f17999i) == 2) {
                        c1087b.f18022k.setText(g.a(item.f17998h, 2, this.f18011k));
                    } else {
                        c1087b.f18021j.setVisibility(8);
                        c1087b.f18022k.setVisibility(8);
                    }
                } else {
                    c1087b.f18021j.setVisibility(8);
                    c1087b.f18022k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18005e : invokeV.intValue;
    }
}
