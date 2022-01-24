package c.a.t0.x2;

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
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f24986e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.x2.b f24987f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f24988g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24989h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24990i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24991j;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24992b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f24993c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24994d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f24995e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f24996f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24997g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f24998h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f24999i;

        /* renamed from: j  reason: collision with root package name */
        public Button f25000j;
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

    public c(PersonBarActivity personBarActivity, c.a.t0.x2.b bVar, boolean z, boolean z2) {
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
        this.f24987f = null;
        this.f24988g = null;
        this.f24989h = false;
        this.f24990i = null;
        this.f24991j = false;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f24986e = personBarActivity;
        this.f24987f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f24986e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f24986e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24991j = false;
            ArrayList<ForumData> arrayList = this.f24988g;
            if (arrayList == null || arrayList.size() == 0) {
                this.f24991j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24989h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24991j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24990i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f24989h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f24988g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f24991j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f24988g;
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
            ArrayList<ForumData> arrayList = this.f24988g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f24988g.get(i2);
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
                    view = LayoutInflater.from(this.f24986e.getPageContext().getContext()).inflate(c.a.t0.z2.e.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(c.a.t0.z2.d.forum_avatar);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(n.f(this.f24986e, c.a.t0.z2.b.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.f24992b = (TextView) view.findViewById(c.a.t0.z2.d.name);
                    bVar.f24993c = new StringBuffer(10);
                    bVar.f24994d = (TextView) view.findViewById(c.a.t0.z2.d.degree);
                    bVar.f24995e = (TextView) view.findViewById(c.a.t0.z2.d.degree_text);
                    bVar.f24999i = (TextView) view.findViewById(c.a.t0.z2.d.experience);
                    bVar.f24997g = (TextView) view.findViewById(c.a.t0.z2.d.experience_title);
                    bVar.f25000j = (Button) view.findViewById(c.a.t0.z2.d.item_delete);
                    bVar.f24996f = (ImageView) view.findViewById(c.a.t0.z2.d.degree_text_ta);
                    bVar.f24998h = (TextView) view.findViewById(c.a.t0.z2.d.intro_ta);
                    bVar.k = (ImageView) view.findViewById(c.a.t0.z2.d.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(c.a.t0.z2.d.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(c.a.t0.z2.d.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.f24991j) {
                    bVar.f24994d.setVisibility(8);
                    bVar.f25000j.setVisibility(8);
                    bVar.f24992b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.f24995e.setVisibility(8);
                    bVar.f24999i.setVisibility(8);
                    bVar.f24997g.setVisibility(8);
                    bVar.f24996f.setVisibility(8);
                    bVar.f24998h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f24992b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.k) {
                        bVar.f24994d.setVisibility(8);
                        bVar.f24995e.setVisibility(8);
                        bVar.f24999i.setVisibility(0);
                        bVar.f24997g.setVisibility(0);
                        bVar.f24996f.setVisibility(0);
                        bVar.f24998h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f24994d.setVisibility(8);
                        bVar.f24995e.setVisibility(8);
                        bVar.f24999i.setVisibility(8);
                        bVar.f24997g.setVisibility(8);
                        bVar.f24996f.setVisibility(0);
                        bVar.f24998h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f24988g != null && i2 >= 0 && i2 < this.f24988g.size() && (forumData = this.f24988g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(image_url, 10, false);
                    bVar.f24993c.delete(0, bVar.f24993c.length());
                    bVar.f24993c.append(forumData.getName());
                    bVar.f24993c.append(this.f24986e.getPageContext().getString(c.a.t0.z2.g.forum));
                    bVar.f24992b.setText(bVar.f24993c);
                    if (this.k) {
                        SkinManager.setImageResource(bVar.f24996f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24999i.setText(String.format(this.f24986e.getPageContext().getString(c.a.t0.z2.g.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.f25000j.setOnClickListener(this.f24990i);
                        bVar.f25000j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f24987f.k()) {
                            bVar.f24992b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.t0.z2.c.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f24992b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f24986e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f24986e.getCurrentPageType() == 0 && i2 < this.f24987f.k()) || (this.f24986e.getCurrentPageType() == 1 && i2 < this.f24987f.g())) {
                            bVar.f24992b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(c.a.t0.z2.c.icon_v), (Drawable) null);
                        } else {
                            bVar.f24992b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f24986e.getCurrentPageType() == 1) {
                            bVar.f24996f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f24996f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f24998h.setText(forumData.getSlogan());
                    }
                    if (this.f24989h) {
                        bVar.f25000j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.f25000j.setVisibility(8);
                        if (i2 < this.f24987f.k() && this.k && !this.l && this.m) {
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
            if (this.f24991j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
