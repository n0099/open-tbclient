package c.a.p0.q4.m.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f17807b;

    /* renamed from: c  reason: collision with root package name */
    public c f17808c;

    /* renamed from: d  reason: collision with root package name */
    public String f17809d;

    /* renamed from: c.a.p0.q4.m.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1342a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17810b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f17811c;

        public View$OnClickListenerC1342a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17811c = aVar;
            this.a = musicList;
            this.f17810b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17811c.f17808c == null) {
                return;
            }
            this.f17811c.f17808c.w0(view, this.a.resource, this.f17810b);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f17812b;

        /* renamed from: c  reason: collision with root package name */
        public View f17813c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17814d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17815e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17816f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17817g;

        /* renamed from: h  reason: collision with root package name */
        public View f17818h;

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

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                SkinManager.setViewTextColor(this.f17814d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f17815e, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f17816f, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f17817g, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f17817g, R.drawable.obfuscated_res_0x7f0802b3);
                SkinManager.setBackgroundColor(this.f17818h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f17812b, R.drawable.obfuscated_res_0x7f08039a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void w0(View view, String str, int i);
    }

    public a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17809d = "";
        this.a = fVar;
        this.f17807b = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f17807b.contains(musicList)) {
                this.f17807b.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.f17807b.get(i) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f17809d = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f17808c = cVar;
        }
    }

    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            getItem(i).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17807b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01eb, viewGroup, false);
                bVar = new b();
                bVar.f17812b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09148c);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091489);
                bVar.a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.a.setIsRound(true);
                bVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080302);
                bVar.a.setDefaultBgResource(R.color.transparent);
                bVar.a.setBorderWidth(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070224));
                bVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.a.setConrers(15);
                bVar.f17813c = view.findViewById(R.id.obfuscated_res_0x7f09148a);
                bVar.f17814d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09148d);
                bVar.f17815e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091486);
                bVar.f17816f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091488);
                bVar.f17817g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091487);
                bVar.f17818h = view.findViewById(R.id.obfuscated_res_0x7f091255);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f17807b.get(i);
            if (musicList != null) {
                bVar.f17814d.setText(musicList.name);
                bVar.a.J(musicList.image, 10, false);
                bVar.f17815e.setText(musicList.author);
                bVar.f17816f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f17813c.setVisibility(0);
                } else {
                    bVar.f17813c.setVisibility(4);
                }
                if (musicList.equals(c.a.p0.q4.m.i.a.b().a())) {
                    bVar.f17812b.setImageResource(R.drawable.obfuscated_res_0x7f08039c);
                    bVar.a.setDrawBorder(true);
                    bVar.f17817g.setVisibility(0);
                    bVar.f17813c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f17817g.setOnClickListener(new View$OnClickListenerC1342a(this, musicList, i));
                } else if (c.a.p0.q4.m.i.a.b().a() == null && getItem(i) != null && !TextUtils.isEmpty(this.f17809d) && this.f17809d.equals(String.valueOf(getItem(i).music_id))) {
                    bVar.f17812b.setImageResource(R.drawable.obfuscated_res_0x7f08039a);
                    bVar.a.setDrawBorder(true);
                    bVar.f17817g.setVisibility(8);
                    bVar.f17813c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f17812b.setImageResource(R.drawable.obfuscated_res_0x7f08039a);
                    bVar.a.setDrawBorder(false);
                    bVar.f17817g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
