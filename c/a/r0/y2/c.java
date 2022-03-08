package c.a.r0.y2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f24916e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.y2.b f24917f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f24918g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24919h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24920i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24921j;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24922b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f24923c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24924d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24925e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f24926f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24927g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f24928h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f24929i;

        /* renamed from: j  reason: collision with root package name */
        public Button f24930j;
        public ImageView k;
        public ImageView l;
        public ImageView m;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonBarActivity personBarActivity, c.a.r0.y2.b bVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personBarActivity, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24917f = null;
        this.f24918g = null;
        this.f24919h = false;
        this.f24920i = null;
        this.f24921j = false;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f24916e = personBarActivity;
        this.f24917f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f24916e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f24916e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24921j = false;
            ArrayList<ForumData> arrayList = this.f24918g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f24921j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24919h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24921j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24920i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f24919h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f24918g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f24921j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f24918g;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<ForumData> arrayList = this.f24918g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f24918g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            try {
                if (view == null) {
                    view = LayoutInflater.from(this.f24916e.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(n.f(this.f24916e, R.dimen.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.f24922b = (TextView) view.findViewById(R.id.name);
                    bVar.f24923c = new StringBuffer(10);
                    bVar.f24924d = (TextView) view.findViewById(R.id.degree);
                    bVar.f24925e = (TextView) view.findViewById(R.id.degree_text);
                    bVar.f24929i = (TextView) view.findViewById(R.id.experience);
                    bVar.f24927g = (TextView) view.findViewById(R.id.experience_title);
                    bVar.f24930j = (Button) view.findViewById(R.id.item_delete);
                    bVar.f24926f = (ImageView) view.findViewById(R.id.degree_text_ta);
                    bVar.f24928h = (TextView) view.findViewById(R.id.intro_ta);
                    bVar.k = (ImageView) view.findViewById(R.id.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(R.id.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(R.id.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f24921j) {
                    bVar.f24924d.setVisibility(8);
                    bVar.f24930j.setVisibility(8);
                    bVar.f24922b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.f24925e.setVisibility(8);
                    bVar.f24929i.setVisibility(8);
                    bVar.f24927g.setVisibility(8);
                    bVar.f24926f.setVisibility(8);
                    bVar.f24928h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f24922b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.k) {
                        bVar.f24924d.setVisibility(8);
                        bVar.f24925e.setVisibility(8);
                        bVar.f24929i.setVisibility(0);
                        bVar.f24927g.setVisibility(0);
                        bVar.f24926f.setVisibility(0);
                        bVar.f24928h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f24924d.setVisibility(8);
                        bVar.f24925e.setVisibility(8);
                        bVar.f24929i.setVisibility(8);
                        bVar.f24927g.setVisibility(8);
                        bVar.f24926f.setVisibility(0);
                        bVar.f24928h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f24918g != null && i2 >= 0 && i2 < this.f24918g.size() && (forumData = this.f24918g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(image_url, 10, false);
                    bVar.f24923c.delete(0, bVar.f24923c.length());
                    bVar.f24923c.append(forumData.getName());
                    bVar.f24923c.append(this.f24916e.getPageContext().getString(R.string.forum));
                    bVar.f24922b.setText(bVar.f24923c);
                    if (this.k) {
                        SkinManager.setImageResource(bVar.f24926f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24929i.setText(String.format(this.f24916e.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.f24930j.setOnClickListener(this.f24920i);
                        bVar.f24930j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f24917f.k()) {
                            bVar.f24922b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f24922b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f24916e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f24916e.getCurrentPageType() == 0 && i2 < this.f24917f.k()) || (this.f24916e.getCurrentPageType() == 1 && i2 < this.f24917f.g())) {
                            bVar.f24922b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            bVar.f24922b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f24916e.getCurrentPageType() == 1) {
                            bVar.f24926f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f24926f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24928h.setText(forumData.getSlogan());
                    }
                    if (this.f24919h) {
                        bVar.f24930j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.f24930j.setVisibility(8);
                        if (i2 < this.f24917f.k() && this.k && !this.l && this.m) {
                            bVar.k.setVisibility(0);
                        } else {
                            bVar.k.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            a(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.o = str;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.f24921j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
