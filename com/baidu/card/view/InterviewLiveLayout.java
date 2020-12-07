package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class InterviewLiveLayout extends FrameLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean alo;
    private TbImageView alp;
    private LinearLayout alq;
    private ImageView alr;
    private TextView als;
    private ArrayList<String> alt;
    private by alu;
    private View.OnClickListener alv;
    private TbImageView.b alw;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.alo = true;
        this.agJ = null;
        this.alt = new ArrayList<>();
        this.alv = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (y.getCount(InterviewLiveLayout.this.alt) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.alt.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.alo ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(InterviewLiveLayout.this.alt).iN(InterviewLiveLayout.this.alo).AJ(str).iO(false).a(concurrentHashMap).iP(false).s(InterviewLiveLayout.this.alu).iT(false);
                        ImageViewerConfig ez = aVar.ez(InterviewLiveLayout.this.getContext());
                        ez.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        ez.getIntent().putExtra("source_rect_in_screen", rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
                        ar arVar = new ar("c13327");
                        arVar.w("fid", InterviewLiveLayout.this.forumId);
                        arVar.dY("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(arVar);
                        if (InterviewLiveLayout.this.aix != null) {
                            InterviewLiveLayout.this.aix.a(InterviewLiveLayout.this.alp, InterviewLiveLayout.this.agJ);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.alw = new TbImageView.b() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.alo ? 13 : 14));
                    if (Ei != null) {
                        int width = Ei.getWidth();
                        i = Ei.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alp = (TbImageView) findViewById(R.id.img_interview_live);
        this.alp.sY(15);
        this.alp.setPlaceHolder(3);
        this.alq = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.alr = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.als = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        if (aVar == null || this.alp == null) {
            setVisibility(8);
            return;
        }
        by bmn = aVar.bmn();
        bw bov = bmn.bov();
        if (bov == null) {
            setVisibility(8);
            return;
        }
        this.alu = bmn;
        this.forumId = bmn.getFid();
        this.taskId = bov.getTaskId();
        if (k.blV().isShowImages() && bov != null && !StringUtils.isNull(bov.getThreadImgUrl())) {
            this.alt.clear();
            this.alt.add(bov.getThreadImgUrl());
            setVisibility(0);
            this.alp.setSupportNoImage(true);
            this.alp.setScaleType(ImageView.ScaleType.MATRIX);
            this.alp.setOnDrawListener(this.alw);
            this.alp.startLoad(bov.getThreadImgUrl(), this.alo ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.alp.setOnClickListener(this.alv);
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.als, R.color.CAM_X0101);
            ap.setImageResource(this.alr, R.drawable.interview_live_circle_share);
            ap.setBackgroundResource(this.alq, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.alp != null) {
            this.alp.setPageId(bdUniqueId);
        }
    }
}
