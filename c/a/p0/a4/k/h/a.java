package c.a.p0.a4.k.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f15467e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f15468f;

    /* renamed from: g  reason: collision with root package name */
    public c f15469g;

    /* renamed from: h  reason: collision with root package name */
    public String f15470h;

    /* renamed from: c.a.p0.a4.k.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0735a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f15471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f15473g;

        public View$OnClickListenerC0735a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15473g = aVar;
            this.f15471e = musicList;
            this.f15472f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15473g.f15469g == null) {
                return;
            }
            this.f15473g.f15469g.onMusicChooseClick(view, this.f15471e.resource, this.f15472f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15474a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15475b;

        /* renamed from: c  reason: collision with root package name */
        public View f15476c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15477d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15478e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15479f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15480g;

        /* renamed from: h  reason: collision with root package name */
        public View f15481h;

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

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                SkinManager.setViewTextColor(this.f15477d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f15478e, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f15479f, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f15480g, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f15480g, R.drawable.bg_music_choose);
                SkinManager.setBackgroundColor(this.f15481h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f15475b, R.drawable.btn_icon_play_video_n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onMusicChooseClick(View view, String str, int i2);
    }

    public a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15470h = "";
        this.f15467e = fVar;
        this.f15468f = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f15468f.contains(musicList)) {
                this.f15468f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f15468f.get(i2) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f15470h = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f15469g = cVar;
        }
    }

    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            getItem(i2).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15468f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f15467e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
                bVar = new b();
                bVar.f15475b = (TbImageView) view.findViewById(R.id.music_state);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
                bVar.f15474a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.f15474a.setIsRound(true);
                bVar.f15474a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                bVar.f15474a.setDefaultBgResource(R.color.transparent);
                bVar.f15474a.setBorderWidth(l.g(this.f15467e.getPageActivity(), R.dimen.ds4));
                bVar.f15474a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.f15474a.setConrers(15);
                bVar.f15476c = view.findViewById(R.id.music_loading);
                bVar.f15477d = (TextView) view.findViewById(R.id.music_title);
                bVar.f15478e = (TextView) view.findViewById(R.id.music_author_name);
                bVar.f15479f = (TextView) view.findViewById(R.id.music_duration);
                bVar.f15480g = (TextView) view.findViewById(R.id.music_choose);
                bVar.f15481h = view.findViewById(R.id.line);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f15468f.get(i2);
            if (musicList != null) {
                bVar.f15477d.setText(musicList.name);
                bVar.f15474a.startLoad(musicList.image, 10, false);
                bVar.f15478e.setText(musicList.author);
                bVar.f15479f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f15476c.setVisibility(0);
                } else {
                    bVar.f15476c.setVisibility(4);
                }
                if (musicList.equals(c.a.p0.a4.k.i.a.b().a())) {
                    bVar.f15475b.setImageResource(R.drawable.btn_icon_stop_video);
                    bVar.f15474a.setDrawBorder(true);
                    bVar.f15480g.setVisibility(0);
                    bVar.f15476c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f15480g.setOnClickListener(new View$OnClickListenerC0735a(this, musicList, i2));
                } else if (c.a.p0.a4.k.i.a.b().a() == null && getItem(i2) != null && !TextUtils.isEmpty(this.f15470h) && this.f15470h.equals(String.valueOf(getItem(i2).music_id))) {
                    bVar.f15475b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f15474a.setDrawBorder(true);
                    bVar.f15480g.setVisibility(8);
                    bVar.f15476c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f15475b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f15474a.setDrawBorder(false);
                    bVar.f15480g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
