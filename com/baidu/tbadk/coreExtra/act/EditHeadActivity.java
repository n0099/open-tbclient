package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private LinearLayout PG;
    private HashMap<String, Bitmap> PJ;
    private HashMap<String, ImageView> PK;
    private View PL;
    private View Pn;
    private View Po;
    private RadioButton Pu;
    private RadioButton Pv;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String Ph = "resourceid";
    public static String Pi = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String Pj = "change";
    public static String FILE_NAME = "file_name";
    private static String[] Pk = null;
    private EditHeadsImageView Pl = null;
    private Bitmap mBitmap = null;
    private int Pm = 0;
    private Button Pp = null;
    private Button Pq = null;
    private HorizontalScrollView Pr = null;
    private ProgressBar mProgress = null;
    private m Ps = null;
    private j Pt = null;
    private LinearLayout Pw = null;
    private LinearLayout Px = null;
    private o Py = null;
    private TextView mTitle = null;
    private Bitmap Pz = null;
    private n PA = null;
    private int PC = 0;
    private int PD = 0;
    private boolean PE = true;
    private String PF = null;
    private boolean PH = false;
    private final Handler mHandler = new Handler();

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(EditHeadActivityConfig.class, EditHeadActivity.class);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra(EditHeadActivityConfig.ACCOUNTDATA, accountData);
        intent.putExtra("edit_type", i3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.da().Z("motu_sdk") == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.PE = false;
        } else {
            this.PE = true;
        }
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.edit_head_activity);
        Intent intent = getIntent();
        this.Pm = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), bg.pI().pO());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, bg.pI().pO(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        Pk = getResources().getStringArray(com.baidu.tieba.r.fiter_name);
        if (this.PE) {
            TbadkCoreApplication.m255getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.j(this.mNavigationBar, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.Pn);
        getLayoutMode().h(this.mTitle);
        getLayoutMode().h(this.Po);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.Ps != null) {
            this.Ps.cancel();
        }
        this.Pl.setImageDrawable(null);
        rj();
    }

    private void rj() {
        if (this.PK != null) {
            for (Map.Entry<String, ImageView> entry : this.PK.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.PK.clear();
            this.PK = null;
        }
        if (this.PJ != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.PJ.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.PJ.clear();
            this.PJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.Ps != null) {
            this.Ps.cancel();
        }
        this.Ps = new m(this, null);
        this.Ps.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.Pl.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.Py != null) {
            this.Py.cancel();
        }
        if (this.Pz != null && !this.Pz.isRecycled()) {
            this.Pz.recycle();
            this.Pz = null;
        }
        if (this.Ps != null) {
            this.Ps.cancel();
            this.Ps = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.PA);
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        if (this.Py != null) {
            this.Py.cancel();
        }
        this.Py = new o(this, null);
        this.Py.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mProgress.setVisibility(8);
        this.Pl = (EditHeadsImageView) findViewById(com.baidu.tieba.w.image);
        if (this.mBitmap != null) {
            this.Pl.setImageBitmap(this.mBitmap);
        }
        this.Pr = (HorizontalScrollView) findViewById(com.baidu.tieba.w.filters_layout);
        this.Pn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.Pq = (Button) findViewById(com.baidu.tieba.w.show_button);
        this.Pq.setOnClickListener(new b(this));
        this.Pp = (Button) findViewById(com.baidu.tieba.w.hide_button);
        this.Pp.setVisibility(0);
        this.Pp.setOnClickListener(new c(this));
        this.Po = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, (View.OnClickListener) null);
        this.Po.setOnClickListener(new d(this));
        this.Po.setEnabled(false);
        ((TextView) this.Po.findViewById(com.baidu.tieba.w.save)).setText(com.baidu.tieba.z.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.PG = (LinearLayout) findViewById(com.baidu.tieba.w.filters);
        this.PC = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Px = (LinearLayout) findViewById(com.baidu.tieba.w.beautify_rotate);
        this.Pw = (LinearLayout) findViewById(com.baidu.tieba.w.rotate);
        this.Pu = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.Pv = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        f fVar = new f(this);
        this.Pu.setOnCheckedChangeListener(fVar);
        this.Pv.setOnCheckedChangeListener(fVar);
        this.Pu.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.w.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.w.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.w.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.w.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        g gVar = new g(this);
        button.setOnClickListener(gVar);
        button2.setOnClickListener(gVar);
        button3.setOnClickListener(gVar);
        button4.setOnClickListener(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(String str) {
        if (this.Pt != null) {
            this.Pt.cancel();
        }
        this.Pt = new j(this, null);
        this.Pt.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.s.a(null, str, bitmap, 80);
            if (this.PH) {
                new ba("motu_pic", String.valueOf(this.PD)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String[] strArr) {
        if (this.PJ != null && strArr != null) {
            this.PG.removeAllViews();
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.w.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.w.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dF(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new h(this, substring, i2));
                    this.PL = imageView2;
                } else {
                    imageView2.setOnClickListener(new i(this, substring, i2));
                }
                this.PG.addView(inflate2);
                if (this.PK != null) {
                    this.PK.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            dd(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.PK == null) {
                this.PK = new HashMap<>();
            }
            if (this.PF != null && (imageView = this.PK.get(this.PF)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.PC, this.PC, this.PC, this.PC);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.PK.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.v.round_corner);
                imageView2.setPadding(this.PC, this.PC, this.PC, this.PC);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.PF = str;
        }
    }

    private void regReceiver() {
        this.PA = new n(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.PA, intentFilter);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
