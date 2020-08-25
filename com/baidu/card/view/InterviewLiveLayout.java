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
import com.baidu.card.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class InterviewLiveLayout extends FrameLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    private aa<AbsThreadDataSupport> agI;
    private boolean ajr;
    private TbImageView ajs;
    private LinearLayout ajt;
    private ImageView aju;
    private TextView ajv;
    private ArrayList<String> ajw;
    private bw ajx;
    private View.OnClickListener ajy;
    private TbImageView.c ajz;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ajr = true;
        this.aeW = null;
        this.ajw = new ArrayList<>();
        this.ajy = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (y.getCount(InterviewLiveLayout.this.ajw) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.ajw.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.ajr ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(InterviewLiveLayout.this.ajw).hH(InterviewLiveLayout.this.ajr).yS(str).hI(false).a(concurrentHashMap).hJ(false).r(InterviewLiveLayout.this.ajx).hN(false);
                        ImageViewerConfig dP = aVar.dP(InterviewLiveLayout.this.getContext());
                        dP.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        dP.getIntent().putExtra("source_rect_in_screen", rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
                        aq aqVar = new aq("c13327");
                        aqVar.u("fid", InterviewLiveLayout.this.forumId);
                        aqVar.dD("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(aqVar);
                        if (InterviewLiveLayout.this.agI != null) {
                            InterviewLiveLayout.this.agI.a(InterviewLiveLayout.this.ajs, InterviewLiveLayout.this.aeW);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.ajz = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Cl = c.bsW().Cl(com.baidu.adp.lib.e.c.mM().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.ajr ? 13 : 14));
                    if (Cl != null) {
                        int width = Cl.getWidth();
                        i = Cl.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajs = (TbImageView) findViewById(R.id.img_interview_live);
        this.ajs.qN(15);
        this.ajs.setPlaceHolder(3);
        this.ajt = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.aju = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.ajv = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        if (absThreadDataSupport == null || this.ajs == null) {
            setVisibility(8);
            return;
        }
        bw bce = absThreadDataSupport.bce();
        bu bek = bce.bek();
        if (bek == null) {
            setVisibility(8);
            return;
        }
        this.ajx = bce;
        this.forumId = bce.getFid();
        this.taskId = bek.getTaskId();
        if (k.bbM().isShowImages() && bek != null && !StringUtils.isNull(bek.getThreadImgUrl())) {
            this.ajw.clear();
            this.ajw.add(bek.getThreadImgUrl());
            setVisibility(0);
            this.ajs.setSupportNoImage(true);
            this.ajs.setScaleType(ImageView.ScaleType.MATRIX);
            this.ajs.setOnDrawListener(this.ajz);
            this.ajs.startLoad(bek.getThreadImgUrl(), this.ajr ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.ajs.setOnClickListener(this.ajy);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agI = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.ajv, R.color.cp_cont_a);
            ap.setImageResource(this.aju, R.drawable.interview_live_circle_share);
            ap.setBackgroundResource(this.ajt, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ajs != null) {
            this.ajs.setPageId(bdUniqueId);
        }
    }
}
