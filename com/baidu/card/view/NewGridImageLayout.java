package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class NewGridImageLayout extends LinearLayout implements p<d.a.r0.r.q.a>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f4528e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4529f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4530g;

    /* renamed from: h  reason: collision with root package name */
    public PlayVoiceBntNew f4531h;

    /* renamed from: i  reason: collision with root package name */
    public VoteView f4532i;
    public GridImageLayout j;
    public Context k;
    public d.a.r0.r.q.a l;
    public String m;
    public b0<d.a.r0.r.q.a> n;
    public boolean o;
    public boolean p;
    public LinkedList<MediaData> q;
    public d.a.r0.b1.m.a r;
    public View.OnClickListener s;
    public boolean t;
    public int u;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4533e;

        public a(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4533e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.r0.r.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4533e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4533e.l);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4534e;

        public b(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4534e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.r0.r.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4534e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("1");
            subClickListener.a(view, this.f4534e.l);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4535a;

        public c(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4535a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, this.f4535a.r.r, this.f4535a.q, i2, this.f4535a.l.getThreadData(), this.f4535a.m, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.q.a f4536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4537f;

        public d(NewGridImageLayout newGridImageLayout, d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4537f = newGridImageLayout;
            this.f4536e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadCardUtils.jumpToPB(this.f4536e.getThreadData().u1, this.f4537f.k, this.f4537f.u);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4538a;

        public e(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4538a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.jumpToPB(this.f4538a.l.getThreadData().u1, this.f4538a.k, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4539a;

        public f(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4539a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, true, this.f4539a.q, i2, this.f4539a.l.getThreadData().u1.a(), this.f4539a.m, this.f4539a.l.getThreadData().u1.o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f4540e;

        public g(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4540e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4540e.s == null) {
                return;
            }
            this.f4540e.s.onClick(view);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setVoiceData(b2 b2Var) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, b2Var) == null) || b2Var == null) {
            return;
        }
        if (this.o) {
            this.f4531h.i(new g(this));
        }
        ArrayList<VoiceData$VoiceModel> x1 = (!b2Var.v1 || (originalThreadInfo = b2Var.u1) == null) ? b2Var.x1() : originalThreadInfo.q;
        if (ListUtils.isEmpty(x1)) {
            this.f4531h.setVisibility(8);
            return;
        }
        this.f4531h.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = x1.get(0);
        this.f4531h.setVoiceModel(voiceData$VoiceModel);
        this.f4531h.setTag(voiceData$VoiceModel);
        this.f4531h.b();
        if (voiceData$VoiceModel != null) {
            this.f4531h.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4531h.m();
    }

    public b0<d.a.r0.r.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (b0) invokeV.objValue;
    }

    public final void i(b2 b2Var) {
        boolean z;
        String j;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            ArrayList<MediaData> z0 = b2Var.z0();
            String U = b2Var.U();
            if (!b2Var.v1 || (originalThreadInfo = b2Var.u1) == null) {
                z = false;
            } else if (originalThreadInfo.m) {
                this.j.setVisibility(8);
                return;
            } else {
                z0 = originalThreadInfo.f12237h;
                z = true;
            }
            if (k.c().g() && ListUtils.getCount(z0) != 0) {
                this.q.clear();
                for (int i2 = 0; i2 < z0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(z0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        if (!z) {
                            if (U != null) {
                                if (!U.equals(mediaData.getPostId() + "")) {
                                }
                            }
                        }
                        this.q.add(mediaData);
                    }
                }
                if (ListUtils.getCount(this.q) > 0) {
                    this.j.setVisibility(0);
                    ArrayList<TbRichTextImageInfo> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < this.q.size(); i3++) {
                        MediaData mediaData2 = (MediaData) ListUtils.getItem(this.q, i3);
                        String originalUrl = mediaData2.getOriginalUrl();
                        if (this.q.size() > 1) {
                            j = k(mediaData2);
                        } else {
                            j = j(mediaData2);
                        }
                        TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                        tbRichTextImageInfo.I(j);
                        tbRichTextImageInfo.H(originalUrl);
                        tbRichTextImageInfo.G(mediaData2.isLongPic());
                        int i4 = mediaData2.picWidth;
                        if (i4 > 0 && mediaData2.picHeight > 0) {
                            tbRichTextImageInfo.setWidth(i4);
                            tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                        }
                        arrayList.add(tbRichTextImageInfo);
                    }
                    this.j.setData(arrayList);
                    return;
                }
                this.j.setVisibility(8);
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public final String j(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallPicUrl();
            }
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public final String k(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String smallPicUrl = mediaData.getSmallPicUrl();
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getPicUrl();
            }
            return TextUtils.isEmpty(smallPicUrl) ? mediaData.getSrc_pic() : smallPicUrl;
        }
        return (String) invokeL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4530g = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4529f = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4531h = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
            this.j = gridImageLayout;
            gridImageLayout.setSupportGifPlay(false);
            this.j.setCornerStyle(1);
            this.j.setAfterClickListener(new b(this));
            this.r = new d.a.r0.b1.m.a();
            int i2 = l.p(this.k)[0];
            this.r.D = i2 - (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
            this.r.E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
            this.j.setLayoutStrategy(this.r);
            this.q = new LinkedList<>();
            this.j.setOnImageClickListener(new c(this));
            VoteView voteView = (VoteView) findViewById(R.id.thread_card_vote);
            this.f4532i = voteView;
            voteView.setBgColor(R.color.CAM_X0207);
        }
    }

    public final boolean m(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        InterceptResult invokeLL;
        String j;
        String j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, arrayList2)) == null) {
            if (arrayList == arrayList2) {
                return true;
            }
            if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
                return false;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = arrayList.get(i2);
                MediaData mediaData2 = arrayList2.get(i2);
                if (size > 1) {
                    j = k(mediaData);
                    j2 = k(mediaData2);
                } else {
                    j = j(mediaData);
                    j2 = j(mediaData2);
                }
                if (j != j2 && (j == null || j2 == null || !j.equals(j2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(PollData pollData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pollData)) == null) ? (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: o */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        b2 threadData = aVar.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.u1;
        if (originalThreadInfo != null && this.o) {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f4530g);
            d2.y(R.string.F_X01);
            d2.x(R.dimen.T_X07);
            d.a.r0.r.u.c.d(this.f4529f).x(R.dimen.T_X07);
            this.f4529f.setVisibility(8);
            if (originalThreadInfo.m) {
                ThreadCardUtils.setAbstract(this.f4530g, this.f4529f, new SpannableString(originalThreadInfo.f12236g), threadData, this.f4528e, this.o, this.t);
                SkinManager.setViewTextColor(this.f4530g, R.color.CAM_X0108);
            } else {
                ThreadCardUtils.setAbstract(this.f4530g, this.f4529f, originalThreadInfo.t, threadData, this.f4528e, this.o, this.t);
            }
            if (n(originalThreadInfo.D)) {
                d dVar = new d(this, aVar);
                this.f4532i.setOnClickListener(dVar);
                this.f4532i.setOnItemClickListener(dVar);
                this.f4532i.setIsTransmit(true);
                this.f4532i.setData(originalThreadInfo.D, originalThreadInfo.f12235f, originalThreadInfo.f12234e);
                this.f4532i.setVisibility(0);
            } else {
                this.f4532i.setVisibility(8);
            }
        } else {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.f4532i.setVisibility(8);
            this.f4530g.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            this.f4530g.setLineSpacing(l.g(this.k, R.dimen.M_T_X002), 1.0f);
            this.f4529f.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.f4529f, threadData, this.t);
            ThreadCardUtils.setAbstract(this.f4530g, this.f4529f, threadData.j(), threadData, this.f4528e, this.o, this.t);
        }
        if (r(threadData)) {
            i(threadData);
        }
        setVoiceData(threadData);
        this.l = aVar;
        if (aVar.getThreadData().u1 == null) {
            return;
        }
        if (threadData.v1) {
            if (this.l.getThreadData().u1 == null) {
                return;
            }
            if (!this.l.getThreadData().u1.m) {
                this.j.setOnImageClickListener(new e(this));
            }
        }
        if (!this.l.getThreadData().u1.m) {
            this.j.setOnImageClickListener(new f(this));
        }
        if (this.o) {
            if (this.l.getThreadData().u1 != null && !this.l.getThreadData().u1.m) {
                setOnClickListener(this);
            } else {
                setOnClickListener(null);
            }
            setClickable(true);
            return;
        }
        setOnClickListener(null);
        setClickable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (onClickListener = this.s) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.p();
            }
            VoteView voteView = this.f4532i;
            if (voteView != null) {
                voteView.C(i2);
            }
        }
    }

    public final void q(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean r(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, b2Var)) == null) {
            d.a.r0.r.q.a aVar = this.l;
            if (aVar == null || aVar.getThreadData() == null) {
                return true;
            }
            if (this.l.getThreadData().n1() == null || this.l.getThreadData().n1().equals(b2Var.n1())) {
                if (b2Var.v1 && b2Var.u1 != null) {
                    if (this.l.getThreadData().u1 == null) {
                        return true;
                    }
                    return !m(b2Var.u1.f12237h, this.l.getThreadData().u1.f12237h);
                }
                return !m(b2Var.z0(), this.l.getThreadData().z0());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCornerStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.j.setCornerStyle(i2);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.m = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setFromForPb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.t = z;
        }
    }

    public void setObjectPool(d.a.c.e.k.b<ImageView> bVar, d.a.c.e.k.b<GifView> bVar2) {
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bVar, bVar2) == null) || (gridImageLayout = this.j) == null) {
            return;
        }
        gridImageLayout.setObjectPool(bVar, bVar2);
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<d.a.r0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b0Var) == null) {
            this.n = b0Var;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.o = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f4528e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.o = false;
        this.t = false;
        this.k = context;
        l();
    }
}
