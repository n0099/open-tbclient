package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agj;
    private View.OnClickListener agk;
    private a ajb;
    private TbImageView.c akW;
    protected boolean alr;
    public RelativeLayout amA;
    protected boolean amB;
    protected String amC;
    protected long amD;
    protected long amE;
    private ab<com.baidu.tbadk.core.data.a> amF;
    public TbImageView ams;
    public View amt;
    private ImageView amu;
    private ImageView amv;
    private TextView amw;
    private TextView amx;
    private TextView amy;
    public RelativeLayout amz;
    private Context mContext;
    protected long mFid;
    private int mSkinType;
    private WeakReference<Context> mWeakContext;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mWeakContext = null;
        this.alr = false;
        this.akW = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Dk = c.bCP().Dk(d.mw().genCacheKey(tbImageView.getUrl(), 10));
                    if (Dk != null) {
                        int width = Dk.getWidth();
                        i = Dk.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f9 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f9 < width2 * 0.5f) {
                                    f8 = 0.0f;
                                } else if ((i2 * f5) - f9 < width2 * 0.5f) {
                                    f8 = width2 - (i2 * f5);
                                } else {
                                    f8 = (width2 * 0.5f) - f9;
                                }
                                f6 = 0.0f;
                                f7 = f8;
                            } else {
                                f5 = width2 / i2;
                                float f10 = i * smartCropCenterPointHeightRatio * f5;
                                if (f10 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = 0.0f;
                                } else if ((i * f5) - f10 < height * 0.5f) {
                                    f6 = height - (i * f5);
                                    f7 = 0.0f;
                                } else {
                                    f6 = (height * 0.5f) - f10;
                                    f7 = 0.0f;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f7, f6);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f = height / i;
                                f3 = (width2 - (i2 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i2;
                                f2 = (height - (i * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (VideoImageNoPlayerLayout.this.alr && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amz = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.amA = (RelativeLayout) findViewById(R.id.video_container);
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.ams = (TbImageView) findViewById(R.id.video_thumbnail);
        this.amt = findViewById(R.id.video_thumbnail_mask);
        this.amu = (ImageView) findViewById(R.id.video_play);
        this.amv = (ImageView) findViewById(R.id.video_pause);
        this.amw = (TextView) findViewById(R.id.video_play_count);
        this.amx = (TextView) findViewById(R.id.video_play_flag);
        this.amy = (TextView) findViewById(R.id.video_duration);
        this.ams.setConrers(15);
        this.ams.setRadiusById(R.string.J_X05);
        this.ams.setDrawCorner(true);
        this.ams.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.amF != null) {
                    VideoImageNoPlayerLayout.this.amF.a(VideoImageNoPlayerLayout.this.ams, VideoImageNoPlayerLayout.this.agj);
                }
                if (VideoImageNoPlayerLayout.this.agk != null) {
                    VideoImageNoPlayerLayout.this.agk.onClick(VideoImageNoPlayerLayout.this.ams);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.CAM_X0206);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.amz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bln() != null && aVar.bln().eTc != null) {
            OriginalThreadInfo originalThreadInfo = aVar.bln().eTc;
            this.amB = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.amC = originalThreadInfo.threadId;
            this.amD = originalThreadInfo.videoInfo.video_length.intValue();
            this.amE = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.amy.setText(au.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.amw.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.amx.setVisibility(8);
            this.ams.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.alr = z;
    }

    public void setOnCardSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.amF = abVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.ajb = aVar;
        if (aVar != null) {
            tp();
        }
    }

    private void tp() {
        if (this.amA != null) {
            this.amA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.ajb.a(VideoImageNoPlayerLayout.this.agj);
                }
            });
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.amt).oe(R.array.Mask_X001);
            com.baidu.tbadk.core.elementsMaven.c.br(this.amt).og(R.string.J_X05);
            ap.setBackgroundColor(this.amz, R.color.CAM_X0206);
            ap.setBackgroundColor(this.amA, R.color.CAM_X0206);
            ap.setBackgroundColor(this, R.color.CAM_X0206);
            this.amu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }
}
