package c.a.p0.v3.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f19222b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f19223c;

    /* renamed from: d  reason: collision with root package name */
    public int f19224d;

    /* renamed from: e  reason: collision with root package name */
    public int f19225e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19226f;

    /* renamed from: g  reason: collision with root package name */
    public ForumDetailActivityConfig.FromType f19227g;

    /* renamed from: h  reason: collision with root package name */
    public ForumInfoData[] f19228h;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19229b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19230c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19231d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19232e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19233f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f19234g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f19235h;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19222b = -1;
        this.f19224d = 0;
        this.f19225e = 0;
        this.f19226f = true;
        this.f19227g = ForumDetailActivityConfig.FromType.BAR_DIR;
        this.a = tbPageContext;
        this.f19225e = i;
        this.f19228h = new ForumInfoData[0];
    }

    public ForumInfoData[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19228h : (ForumInfoData[]) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 100000) {
                return String.valueOf(i / 10000) + this.a.getString(R.string.obfuscated_res_0x7f0f0aa2);
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LikeModel likeModel = this.f19223c;
            if (likeModel == null) {
                return false;
            }
            return likeModel.N();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f19224d = i;
            notifyDataSetChanged();
        }
    }

    public void f(ForumInfoData[] forumInfoDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumInfoDataArr) == null) {
            this.f19228h = forumInfoDataArr;
            if (forumInfoDataArr != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void g(ForumDetailActivityConfig.FromType fromType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fromType) == null) {
            this.f19227g = fromType;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ForumInfoData[] forumInfoDataArr = this.f19228h;
            if (forumInfoDataArr == null) {
                return 0;
            }
            int i = this.f19224d;
            return i <= forumInfoDataArr.length ? i : forumInfoDataArr.length;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i > this.f19224d) {
                return null;
            }
            return this.f19228h[i];
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            if (view == null || view.getTag() == null) {
                view = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d02bc, null);
                a aVar = new a(this);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
                aVar.a = barImageView;
                barImageView.setGifIconSupport(false);
                aVar.f19231d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                aVar.f19232e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0913d2);
                aVar.f19233f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091fa6);
                aVar.f19234g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091d31);
                aVar.f19235h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09124c);
                aVar.f19229b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919af);
                aVar.f19230c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ac0);
                view.setTag(aVar);
            }
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f09033d);
            View findViewById2 = view.findViewById(R.id.obfuscated_res_0x7f09033c);
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
            if (i == 0) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            a aVar2 = (a) view.getTag();
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(view);
            ForumInfoData[] forumInfoDataArr = this.f19228h;
            ForumInfoData forumInfoData = forumInfoDataArr[i];
            String str = forumInfoDataArr[i].avatar;
            aVar2.a.setTag(str);
            aVar2.a.invalidate();
            aVar2.a.J(str, 10, false);
            aVar2.f19231d.setText(forumInfoData.forum_name);
            aVar2.f19231d.setTag(Integer.valueOf(forumInfoData.forum_id));
            aVar2.f19235h.setTag(forumInfoData.forum_name);
            TextView textView = aVar2.f19232e;
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f029b) + " " + b(forumInfoData.member_count));
            TextView textView2 = aVar2.f19233f;
            textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1385) + " " + b(forumInfoData.thread_count));
            aVar2.f19234g.setText(forumInfoData.slogan);
            if (this.f19225e == 0) {
                aVar2.f19230c.setVisibility(8);
                if (!this.f19226f) {
                    aVar2.f19229b.setVisibility(8);
                } else {
                    aVar2.f19229b.setVisibility(0);
                    aVar2.f19229b.setText((CharSequence) null);
                    aVar2.f19229b.setBackgroundDrawable(null);
                    if (i == 0) {
                        SkinManager.setBackgroundResource(aVar2.f19229b, R.drawable.icon_brief_grade_orange);
                    } else if (i == 1) {
                        SkinManager.setBackgroundResource(aVar2.f19229b, R.drawable.icon_brief_grade_blue);
                    } else if (i != 2) {
                        aVar2.f19229b.setText(String.format("%02d", Integer.valueOf(i + 1)));
                    } else {
                        SkinManager.setBackgroundResource(aVar2.f19229b, R.drawable.icon_brief_grade_green);
                    }
                }
            } else {
                aVar2.f19229b.setVisibility(8);
                aVar2.f19230c.setVisibility(0);
                aVar2.f19230c.setText((CharSequence) null);
                aVar2.f19230c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
                TextView textView3 = aVar2.f19230c;
                textView3.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0fbf) + String.valueOf(forumInfoData.mbr_inter_rank) + this.a.getString(R.string.obfuscated_res_0x7f0f0c9d));
            }
            aVar2.f19235h.setOnClickListener(this);
            view.setOnClickListener(this);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bool) == null) {
            this.f19226f = bool.booleanValue();
        }
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) || i == 0 || i2 == 0) {
            return;
        }
        notifyDataSetChanged();
    }

    public void j(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, likeModel) == null) {
            this.f19223c = likeModel;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (int i = 0; i < this.f19224d; i++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.f19228h[i].forum_name);
                if (hasLikeForum == 1) {
                    this.f19228h[i].is_like = 1;
                } else if (hasLikeForum == -1) {
                    this.f19228h[i].is_like = 0;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f09124c) {
                TiebaStatic.eventStat(this.a.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
                return;
            }
            a aVar = (a) view.getTag();
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.getPageActivity(), String.valueOf(aVar.f19231d.getTag()), this.f19227g)));
                return;
            }
            TiebaStatic.eventStat(this.a.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(aVar.f19231d.getText().toString(), null)));
        }
    }
}
