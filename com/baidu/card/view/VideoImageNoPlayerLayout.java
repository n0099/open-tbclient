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
/* loaded from: classes21.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private View.OnClickListener agK;
    private a ajv;
    protected boolean alQ;
    private TbImageView.b alw;
    public TbImageView amP;
    private ImageView amQ;
    private ImageView amR;
    private TextView amS;
    private TextView amT;
    private TextView amU;
    public RelativeLayout amV;
    public RelativeLayout amW;
    protected boolean amX;
    protected String amY;
    protected long amZ;
    protected long ana;
    private ab<com.baidu.tbadk.core.data.a> anb;
    private Context mContext;
    protected long mFid;
    private int mSkinType;
    private WeakReference<Context> mWeakContext;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mWeakContext = null;
        this.alQ = false;
        this.alw = new TbImageView.b() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ei = c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), 10));
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
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i2 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i2;
                                float f9 = i * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
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
                                float f11 = height / i;
                                f2 = f11;
                                f3 = (width2 - (i2 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i2;
                                f = (height - (i * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (VideoImageNoPlayerLayout.this.alQ && i > i2) {
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
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amV = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.amW = (RelativeLayout) findViewById(R.id.video_container);
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.amP = (TbImageView) findViewById(R.id.video_thumbnail);
        this.amQ = (ImageView) findViewById(R.id.video_play);
        this.amR = (ImageView) findViewById(R.id.video_pause);
        this.amS = (TextView) findViewById(R.id.video_play_count);
        this.amT = (TextView) findViewById(R.id.video_play_flag);
        this.amU = (TextView) findViewById(R.id.video_duration);
        this.amP.setConrers(15);
        this.amP.setRadiusById(R.string.J_X05);
        this.amP.setDrawCorner(true);
        this.amP.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.anb != null) {
                    VideoImageNoPlayerLayout.this.anb.a(VideoImageNoPlayerLayout.this.amP, VideoImageNoPlayerLayout.this.agJ);
                }
                if (VideoImageNoPlayerLayout.this.agK != null) {
                    VideoImageNoPlayerLayout.this.agK.onClick(VideoImageNoPlayerLayout.this.amP);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.CAM_X0206);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.amV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null && aVar.bmn().eLH != null) {
            OriginalThreadInfo originalThreadInfo = aVar.bmn().eLH;
            this.amX = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.amY = originalThreadInfo.threadId;
            this.amZ = originalThreadInfo.videoInfo.video_length.intValue();
            this.ana = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.amU.setText(au.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.amS.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.amT.setVisibility(8);
            this.amP.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.alQ = z;
    }

    public void setOnCardSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.anb = abVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.ajv = aVar;
        if (aVar != null) {
            ue();
        }
    }

    private void ue() {
        if (this.amW != null) {
            this.amW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.ajv.a(VideoImageNoPlayerLayout.this.agJ);
                }
            });
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.amV, R.color.CAM_X0206);
            ap.setBackgroundColor(this.amW, R.color.CAM_X0206);
            ap.setBackgroundColor(this, R.color.CAM_X0206);
            this.amQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agK = onClickListener;
    }
}
