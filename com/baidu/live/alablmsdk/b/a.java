package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes11.dex */
public class a {
    private static String aCh = "";
    private com.baidu.live.alablmsdk.e.b aCf;
    com.baidu.live.alablmsdk.module.b.a aCg;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.aCf = bVar;
    }

    public static void fK(String str) {
        com.baidu.live.alablmsdk.a.b.a.aj("setCurrentRoomId " + str, "");
        aCh = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.aCg = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.aCg.toJsonString();
        com.baidu.live.alablmsdk.a.b.a.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        com.baidu.live.alablmsdk.a.b.a.fI(" putCurrentRoomInfo roomInfo " + jsonString);
        d.Bk().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.aCg != null) {
            this.aCg.aCZ = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.aCg.toJsonString();
            com.baidu.live.alablmsdk.a.b.a.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            com.baidu.live.alablmsdk.a.b.a.fI(" updateCurrentRoomStatus roomInfo " + jsonString);
            d.Bk().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void BL() {
        d.Bk().putString("legacy_room_info_kye", "");
    }

    public void BM() {
        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom ");
        com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom ");
        if (this.aCg != null && !TextUtils.isEmpty(this.aCg.roomId) && this.aCg.aCZ == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.aCf != null) {
            final String str = this.aCg.roomId;
            if (this.aCg.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  closeRoom");
                com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom  closeRoom");
                this.aCf.a(this.aCg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.aCg.roomId)) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.BL();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  hangout");
            com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom  hangout");
            this.aCf.hangout(this.aCg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.aCg.roomId)) {
                            a.this.BL();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    com.baidu.live.alablmsdk.a.b.a.fI(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void BN() {
        String string = d.Bk().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.a.aj(" closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + aCh, "");
        this.aCg = com.baidu.live.alablmsdk.module.b.a.fQ(string);
        if (this.aCg != null && !TextUtils.isEmpty(this.aCg.roomId) && !this.aCg.roomId.equals(aCh)) {
            if ((this.aCg.aCZ == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.aCg.aCZ == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.aCf != null) {
                com.baidu.live.alablmsdk.a.b.a.aj(" closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.aCg.roomId, "");
                if (this.aCg.permission == UserPermission.OWNER.getPermission()) {
                    this.aCf.a(this.aCg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.fI(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.BL();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.a.fI(" handleInitLegacyRoom  hangout");
                this.aCf.hangout(this.aCg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.a.fI(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.BL();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        aCh = "";
    }
}
