package c.a.p0.q4.n.e.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f17874e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.q4.n.e.c.b> a;

    /* renamed from: b  reason: collision with root package name */
    public String f17875b;

    /* renamed from: c  reason: collision with root package name */
    public int f17876c;

    /* renamed from: d  reason: collision with root package name */
    public RecordEffectLayout.i f17877d;

    /* renamed from: c.a.p0.q4.n.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1346a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f17878b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17879c;

        /* renamed from: d  reason: collision with root package name */
        public int f17880d;

        public C1346a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1703219893, "Lc/a/p0/q4/n/e/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1703219893, "Lc/a/p0/q4/n/e/b/a;");
                return;
            }
        }
        f17874e = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17876c = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.p0.q4.n.e.c.b getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<c.a.p0.q4.n.e.c.b> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (c.a.p0.q4.n.e.c.b) invokeI.objValue;
    }

    public final void b(C1346a c1346a, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1346a, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090fd0);
            c1346a.a = tbImageView;
            tbImageView.setIsRound(true);
            c1346a.a.setDrawerType(1);
            c1346a.a.setDefaultBgResource(R.color.transparent);
            c1346a.a.setBorderWidth(n.f(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
            c1346a.a.setConrers(15);
            c1346a.a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            c1346a.f17879c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921db);
        }
    }

    public void c(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMusicData) == null) || getCount() <= 1 || getItem(1) == null || getItem(1).getType() != 3) {
            return;
        }
        this.f17876c = 1;
        this.f17875b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0c);
        notifyDataSetChanged();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f17875b = str;
        }
    }

    public void e(List<c.a.p0.q4.n.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.a = list;
            this.f17875b = str;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.f17877d = iVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).getType() == 3 && (getItem(1).c() instanceof MusicData)) {
            ((MusicData) getItem(1).c()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<c.a.p0.q4.n.e.c.b> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            c.a.p0.q4.n.e.c.b item = getItem(i);
            if (item == null) {
                return 0;
            }
            int type = item.getType();
            if (type != 1) {
                return type != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1346a c1346a;
        View view2;
        c.a.p0.q4.n.e.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view, viewGroup)) == null) {
            if (view == null) {
                c1346a = new C1346a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0175, (ViewGroup) null);
                    b(c1346a, view2, viewGroup);
                    c1346a.f17878b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fe0);
                    c1346a.f17879c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0175, (ViewGroup) null);
                    b(c1346a, view2, viewGroup);
                    c1346a.f17878b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f090fe0);
                    c1346a.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080302);
                    c1346a.f17879c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType != 2) {
                    view2 = view;
                } else {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0174, (ViewGroup) null);
                    b(c1346a, view2, viewGroup);
                    c1346a.f17879c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view2.setTag(c1346a);
            } else {
                c1346a = (C1346a) view.getTag();
                view2 = view;
            }
            List<c.a.p0.q4.n.e.c.b> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (bVar = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 == 0) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.c();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView = c1346a.a;
                        String str = qmFilterItem.bgurl;
                        int i2 = f17874e;
                        tbImageView.G(str, 24, i2, i2, false);
                    } else {
                        TbImageView tbImageView2 = c1346a.a;
                        String str2 = qmFilterItem.bgurl;
                        int i3 = f17874e;
                        tbImageView2.G(str2, 10, i3, i3, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.f17875b)) {
                        c1346a.a.setDrawBorder(true);
                    } else {
                        c1346a.a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        c1346a.f17878b.setVisibility(0);
                    } else {
                        c1346a.f17878b.setVisibility(4);
                    }
                    if (this.f17876c != i) {
                        c1346a.f17878b.setVisibility(4);
                    } else if (c1346a.f17878b.getVisibility() == 0) {
                        c1346a.a.setDrawBorder(false);
                    }
                    c1346a.f17879c.setText(bVar.b());
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) bVar.c();
                    int i4 = musicData.editMusicType;
                    if (i4 != 0 && (i4 != 2 || TextUtils.isEmpty(musicData.img))) {
                        TbImageView tbImageView3 = c1346a.a;
                        String valueOf = String.valueOf(bVar.a());
                        int i5 = f17874e;
                        tbImageView3.G(valueOf, 24, i5, i5, false);
                    } else {
                        TbImageView tbImageView4 = c1346a.a;
                        String str3 = musicData.img;
                        int i6 = f17874e;
                        tbImageView4.G(str3, 10, i6, i6, false);
                    }
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f17875b)) {
                        c1346a.a.setDrawBorder(true);
                    } else {
                        c1346a.a.setDrawBorder(false);
                    }
                    if (this.f17876c != i) {
                        c1346a.f17878b.setVisibility(4);
                    } else if (c1346a.f17878b.getVisibility() == 0) {
                        c1346a.a.setDrawBorder(false);
                    }
                    c1346a.f17879c.setText(musicData.name);
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f17875b)) {
                        c1346a.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080247);
                    } else {
                        c1346a.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080246);
                    }
                    c1346a.f17879c.setText(bVar.b());
                }
                c1346a.a.setTag(bVar);
                c1346a.a.setTag(R.id.obfuscated_res_0x7f091a21, c1346a);
                c1346a.a.setOnClickListener(this);
                c1346a.f17880d = i;
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && view.getId() == R.id.obfuscated_res_0x7f090fd0 && (view.getTag() instanceof c.a.p0.q4.n.e.c.b)) {
            c.a.p0.q4.n.e.c.b bVar = (c.a.p0.q4.n.e.c.b) view.getTag();
            if (bVar.getType() == 3 && (bVar.c() instanceof MusicData)) {
                if (view.getResources().getString(R.string.obfuscated_res_0x7f0f0b0c).equals(bVar.b()) && (iVar = this.f17877d) != null) {
                    iVar.b(bVar, view.getTag(R.id.obfuscated_res_0x7f091a21));
                    this.f17876c = this.a.indexOf(bVar);
                    this.f17875b = bVar.b();
                }
                if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f17875b)) {
                    return;
                }
                if (!bVar.b().equals(view.getResources().getString(R.string.obfuscated_res_0x7f0f0b0c))) {
                    this.f17876c = this.a.indexOf(bVar);
                }
            } else {
                this.f17876c = this.a.indexOf(bVar);
            }
            if (bVar.getType() == 2 && (bVar.c() instanceof QmFilterItem)) {
                this.f17875b = ((QmFilterItem) bVar.c()).id;
            } else {
                this.f17875b = bVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.f17877d;
            if (iVar2 != null) {
                iVar2.b(bVar, view.getTag(R.id.obfuscated_res_0x7f091a21));
            }
        }
    }
}
