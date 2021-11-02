package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.AutoScrollHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.facebook.imageutils.WebpUtil;
import com.yy.hiidostatis.message.sender.SendMsgDispatcher;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes.dex */
public class ExifInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
    public static final int[] BITS_PER_SAMPLE_RGB;
    public static final short BYTE_ALIGN_II = 18761;
    public static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final boolean DEBUG;
    public static final byte[] EXIF_ASCII_PREFIX;
    public static final ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final List<Integer> FLIPPED_ROTATION_ORDER;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final byte[] HEIF_BRAND_HEIC;
    public static final byte[] HEIF_BRAND_MIF1;
    public static final byte[] HEIF_TYPE_FTYP;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final byte[] IDENTIFIER_XMP_APP1;
    public static final ExifTag[] IFD_EXIF_TAGS;
    public static final int IFD_FORMAT_BYTE = 1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    public static final int IFD_FORMAT_DOUBLE = 12;
    public static final int IFD_FORMAT_IFD = 13;
    public static final String[] IFD_FORMAT_NAMES;
    public static final int IFD_FORMAT_SBYTE = 6;
    public static final int IFD_FORMAT_SINGLE = 11;
    public static final int IFD_FORMAT_SLONG = 9;
    public static final int IFD_FORMAT_SRATIONAL = 10;
    public static final int IFD_FORMAT_SSHORT = 8;
    public static final int IFD_FORMAT_STRING = 2;
    public static final int IFD_FORMAT_ULONG = 4;
    public static final int IFD_FORMAT_UNDEFINED = 7;
    public static final int IFD_FORMAT_URATIONAL = 5;
    public static final int IFD_FORMAT_USHORT = 3;
    public static final ExifTag[] IFD_GPS_TAGS;
    public static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    public static final int IFD_OFFSET = 8;
    public static final ExifTag[] IFD_THUMBNAIL_TAGS;
    public static final ExifTag[] IFD_TIFF_TAGS;
    public static final int IFD_TYPE_EXIF = 1;
    public static final int IFD_TYPE_GPS = 2;
    public static final int IFD_TYPE_INTEROPERABILITY = 3;
    public static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    public static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    public static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    public static final int IFD_TYPE_PEF = 9;
    public static final int IFD_TYPE_PREVIEW = 5;
    public static final int IFD_TYPE_PRIMARY = 0;
    public static final int IFD_TYPE_THUMBNAIL = 4;
    public static final int IMAGE_TYPE_ARW = 1;
    public static final int IMAGE_TYPE_CR2 = 2;
    public static final int IMAGE_TYPE_DNG = 3;
    public static final int IMAGE_TYPE_HEIF = 12;
    public static final int IMAGE_TYPE_JPEG = 4;
    public static final int IMAGE_TYPE_NEF = 5;
    public static final int IMAGE_TYPE_NRW = 6;
    public static final int IMAGE_TYPE_ORF = 7;
    public static final int IMAGE_TYPE_PEF = 8;
    public static final int IMAGE_TYPE_PNG = 13;
    public static final int IMAGE_TYPE_RAF = 9;
    public static final int IMAGE_TYPE_RW2 = 10;
    public static final int IMAGE_TYPE_SRW = 11;
    public static final int IMAGE_TYPE_UNKNOWN = 0;
    public static final int IMAGE_TYPE_WEBP = 14;
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    public static final byte[] JPEG_SIGNATURE;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte MARKER = -1;
    public static final byte MARKER_APP1 = -31;
    public static final byte MARKER_COM = -2;
    public static final byte MARKER_EOI = -39;
    public static final byte MARKER_SOF0 = -64;
    public static final byte MARKER_SOF1 = -63;
    public static final byte MARKER_SOF10 = -54;
    public static final byte MARKER_SOF11 = -53;
    public static final byte MARKER_SOF13 = -51;
    public static final byte MARKER_SOF14 = -50;
    public static final byte MARKER_SOF15 = -49;
    public static final byte MARKER_SOF2 = -62;
    public static final byte MARKER_SOF3 = -61;
    public static final byte MARKER_SOF5 = -59;
    public static final byte MARKER_SOF6 = -58;
    public static final byte MARKER_SOF7 = -57;
    public static final byte MARKER_SOF9 = -55;
    public static final byte MARKER_SOI = -40;
    public static final byte MARKER_SOS = -38;
    public static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    public static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    public static final byte[] ORF_MAKER_NOTE_HEADER_1;
    public static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    public static final byte[] ORF_MAKER_NOTE_HEADER_2;
    public static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    public static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    public static final short ORF_SIGNATURE_1 = 20306;
    public static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    public static final String PEF_SIGNATURE = "PENTAX";
    public static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    public static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    public static final byte[] PNG_CHUNK_TYPE_EXIF;
    public static final byte[] PNG_CHUNK_TYPE_IEND;
    public static final byte[] PNG_CHUNK_TYPE_IHDR;
    public static final byte[] PNG_SIGNATURE;
    public static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    public static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    public static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    public static final List<Integer> ROTATION_ORDER;
    public static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    public static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final ExifTag TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_CHUNK_TYPE_ANIM;
    public static final byte[] WEBP_CHUNK_TYPE_ANMF;
    public static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_CHUNK_TYPE_EXIF;
    public static final byte[] WEBP_CHUNK_TYPE_VP8;
    public static final byte[] WEBP_CHUNK_TYPE_VP8L;
    public static final byte[] WEBP_CHUNK_TYPE_VP8X;
    public static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    public static final byte[] WEBP_CHUNK_TYPE_XMP;
    public static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_SIGNATURE_1;
    public static final byte[] WEBP_SIGNATURE_2;
    public static final byte WEBP_VP8L_SIGNATURE = 47;
    public static final byte[] WEBP_VP8_SIGNATURE;
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    public static final HashMap<Integer, Integer> sExifPointerTagMap;
    public static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    public static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    public static SimpleDateFormat sFormatter;
    public static final Pattern sGpsTimestampPattern;
    public static final Pattern sNonZeroTimePattern;
    public static final HashSet<String> sTagSetForCompatibility;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAreThumbnailStripsConsecutive;
    public AssetManager.AssetInputStream mAssetInputStream;
    public final HashMap<String, ExifAttribute>[] mAttributes;
    public Set<Integer> mAttributesOffsets;
    public ByteOrder mExifByteOrder;
    public int mExifOffset;
    public String mFilename;
    public boolean mHasThumbnail;
    public boolean mHasThumbnailStrips;
    public boolean mIsExifDataOnly;
    public boolean mIsSupportedFile;
    public int mMimeType;
    public boolean mModified;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public int mRw2JpgFromRawOffset;
    public FileDescriptor mSeekableFileDescriptor;
    public byte[] mThumbnailBytes;
    public int mThumbnailCompression;
    public int mThumbnailLength;
    public int mThumbnailOffset;
    public boolean mXmpIsFromSeparateMarker;

    /* loaded from: classes.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public static /* synthetic */ Interceptable $ic;
        public static final ByteOrder BIG_ENDIAN;
        public static final ByteOrder LITTLE_ENDIAN;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteOrder mByteOrder;
        public DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(874280378, "Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(874280378, "Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;");
                    return;
                }
            }
            LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((InputStream) objArr2[0], (ByteOrder) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDataInputStream.available() : invokeV.intValue;
        }

        public int getLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLength : invokeV.intValue;
        }

        public int peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPosition : invokeV.intValue;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.mPosition++;
                return this.mDataInputStream.read();
            }
            return invokeV.intValue;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                this.mPosition++;
                return this.mDataInputStream.readBoolean();
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i2 = this.mPosition + 1;
                this.mPosition = i2;
                if (i2 <= this.mLength) {
                    int read = this.mDataInputStream.read();
                    if (read >= 0) {
                        return (byte) read;
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            return invokeV.byteValue;
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.mPosition += 2;
                return this.mDataInputStream.readChar();
            }
            return invokeV.charValue;
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Double.longBitsToDouble(readLong()) : invokeV.doubleValue;
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Float.intBitsToFloat(readInt()) : invokeV.floatValue;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048587, this, bArr, i2, i3) == null) {
                int i4 = this.mPosition + i3;
                this.mPosition = i4;
                if (i4 <= this.mLength) {
                    if (this.mDataInputStream.read(bArr, i2, i3) != i3) {
                        throw new IOException("Couldn't read up to the length of buffer");
                    }
                    return;
                }
                throw new EOFException();
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                int i2 = this.mPosition + 4;
                this.mPosition = i2;
                if (i2 <= this.mLength) {
                    int read = this.mDataInputStream.read();
                    int read2 = this.mDataInputStream.read();
                    int read3 = this.mDataInputStream.read();
                    int read4 = this.mDataInputStream.read();
                    if ((read | read2 | read3 | read4) >= 0) {
                        ByteOrder byteOrder = this.mByteOrder;
                        if (byteOrder == LITTLE_ENDIAN) {
                            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                        }
                        if (byteOrder == BIG_ENDIAN) {
                            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                        }
                        throw new IOException("Invalid byte order: " + this.mByteOrder);
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            return invokeV.intValue;
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                int i2 = this.mPosition + 8;
                this.mPosition = i2;
                if (i2 <= this.mLength) {
                    int read = this.mDataInputStream.read();
                    int read2 = this.mDataInputStream.read();
                    int read3 = this.mDataInputStream.read();
                    int read4 = this.mDataInputStream.read();
                    int read5 = this.mDataInputStream.read();
                    int read6 = this.mDataInputStream.read();
                    int read7 = this.mDataInputStream.read();
                    int read8 = this.mDataInputStream.read();
                    if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                        ByteOrder byteOrder = this.mByteOrder;
                        if (byteOrder == LITTLE_ENDIAN) {
                            return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                        }
                        if (byteOrder == BIG_ENDIAN) {
                            return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                        }
                        throw new IOException("Invalid byte order: " + this.mByteOrder);
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            return invokeV.longValue;
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                int i2 = this.mPosition + 2;
                this.mPosition = i2;
                if (i2 <= this.mLength) {
                    int read = this.mDataInputStream.read();
                    int read2 = this.mDataInputStream.read();
                    if ((read | read2) >= 0) {
                        ByteOrder byteOrder = this.mByteOrder;
                        if (byteOrder == LITTLE_ENDIAN) {
                            return (short) ((read2 << 8) + read);
                        }
                        if (byteOrder == BIG_ENDIAN) {
                            return (short) ((read << 8) + read2);
                        }
                        throw new IOException("Invalid byte order: " + this.mByteOrder);
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            return invokeV.shortValue;
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                this.mPosition += 2;
                return this.mDataInputStream.readUTF();
            }
            return (String) invokeV.objValue;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                this.mPosition++;
                return this.mDataInputStream.readUnsignedByte();
            }
            return invokeV.intValue;
        }

        public long readUnsignedInt() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? readInt() & 4294967295L : invokeV.longValue;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                int i2 = this.mPosition + 2;
                this.mPosition = i2;
                if (i2 <= this.mLength) {
                    int read = this.mDataInputStream.read();
                    int read2 = this.mDataInputStream.read();
                    if ((read | read2) >= 0) {
                        ByteOrder byteOrder = this.mByteOrder;
                        if (byteOrder == LITTLE_ENDIAN) {
                            return (read2 << 8) + read;
                        }
                        if (byteOrder == BIG_ENDIAN) {
                            return (read << 8) + read2;
                        }
                        throw new IOException("Invalid byte order: " + this.mByteOrder);
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
            return invokeV.intValue;
        }

        public void seek(long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
                int i2 = this.mPosition;
                if (i2 > j) {
                    this.mPosition = 0;
                    this.mDataInputStream.reset();
                    this.mDataInputStream.mark(this.mLength);
                } else {
                    j -= i2;
                }
                int i3 = (int) j;
                if (skipBytes(i3) != i3) {
                    throw new IOException("Couldn't seek up to the byteCount");
                }
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, byteOrder) == null) {
                this.mByteOrder = byteOrder;
            }
        }

        @Override // java.io.DataInput
        public int skipBytes(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                int min = Math.min(i2, this.mLength - this.mPosition);
                int i3 = 0;
                while (i3 < min) {
                    i3 += this.mDataInputStream.skipBytes(min - i3);
                }
                this.mPosition += i3;
                return i3;
            }
            return invokeI.intValue;
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, byteOrder};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
                int read = this.mDataInputStream.read(bArr, i2, i3);
                this.mPosition += read;
                return read;
            }
            return invokeLII.intValue;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bArr) == null) {
                int length = this.mPosition + bArr.length;
                this.mPosition = length;
                if (length <= this.mLength) {
                    if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                        throw new IOException("Couldn't read up to the length of buffer");
                    }
                    return;
                }
                throw new EOFException();
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteOrder mByteOrder;
        public final OutputStream mOutputStream;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, byteOrder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteOrder) == null) {
                this.mByteOrder = byteOrder;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
                this.mOutputStream.write(bArr);
            }
        }

        public void writeByte(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.mOutputStream.write(i2);
            }
        }

        public void writeInt(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    this.mOutputStream.write((i2 >>> 0) & 255);
                    this.mOutputStream.write((i2 >>> 8) & 255);
                    this.mOutputStream.write((i2 >>> 16) & 255);
                    this.mOutputStream.write((i2 >>> 24) & 255);
                } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    this.mOutputStream.write((i2 >>> 24) & 255);
                    this.mOutputStream.write((i2 >>> 16) & 255);
                    this.mOutputStream.write((i2 >>> 8) & 255);
                    this.mOutputStream.write((i2 >>> 0) & 255);
                }
            }
        }

        public void writeShort(short s) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Short.valueOf(s)}) == null) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    this.mOutputStream.write((s >>> 0) & 255);
                    this.mOutputStream.write((s >>> 8) & 255);
                } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    this.mOutputStream.write((s >>> 8) & 255);
                    this.mOutputStream.write((s >>> 0) & 255);
                }
            }
        }

        public void writeUnsignedInt(long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                writeInt((int) j);
            }
        }

        public void writeUnsignedShort(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                writeShort((short) i2);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
                this.mOutputStream.write(bArr, i2, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ExifAttribute {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ExifAttribute(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1L, bArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), (byte[]) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static ExifAttribute createByte(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                    return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
                }
                byte[] bytes = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes.length, bytes);
            }
            return (ExifAttribute) invokeL.objValue;
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
                wrap.order(byteOrder);
                for (double d2 : dArr) {
                    wrap.putDouble(d2);
                }
                return new ExifAttribute(12, dArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, iArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
                wrap.order(byteOrder);
                for (int i2 : iArr) {
                    wrap.putInt(i2);
                }
                return new ExifAttribute(9, iArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, rationalArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
                wrap.order(byteOrder);
                for (Rational rational : rationalArr) {
                    wrap.putInt((int) rational.numerator);
                    wrap.putInt((int) rational.denominator);
                }
                return new ExifAttribute(10, rationalArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
                byte[] bytes = (str + (char) 0).getBytes(ExifInterface.ASCII);
                return new ExifAttribute(2, bytes.length, bytes);
            }
            return (ExifAttribute) invokeL.objValue;
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, jArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
                wrap.order(byteOrder);
                for (long j : jArr) {
                    wrap.putInt((int) j);
                }
                return new ExifAttribute(4, jArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, rationalArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
                wrap.order(byteOrder);
                for (Rational rational : rationalArr) {
                    wrap.putInt((int) rational.numerator);
                    wrap.putInt((int) rational.denominator);
                }
                return new ExifAttribute(5, rationalArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, iArr, byteOrder)) == null) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
                wrap.order(byteOrder);
                for (int i2 : iArr) {
                    wrap.putShort((short) i2);
                }
                return new ExifAttribute(3, iArr.length, wrap.array());
            }
            return (ExifAttribute) invokeLL.objValue;
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteOrder)) == null) {
                Object value = getValue(byteOrder);
                if (value != null) {
                    if (value instanceof String) {
                        return Double.parseDouble((String) value);
                    }
                    if (value instanceof long[]) {
                        long[] jArr = (long[]) value;
                        if (jArr.length == 1) {
                            return jArr[0];
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else if (value instanceof int[]) {
                        int[] iArr = (int[]) value;
                        if (iArr.length == 1) {
                            return iArr[0];
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else if (value instanceof double[]) {
                        double[] dArr = (double[]) value;
                        if (dArr.length == 1) {
                            return dArr[0];
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else if (value instanceof Rational[]) {
                        Rational[] rationalArr = (Rational[]) value;
                        if (rationalArr.length == 1) {
                            return rationalArr[0].calculate();
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else {
                        throw new NumberFormatException("Couldn't find a double value");
                    }
                }
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            return invokeL.doubleValue;
        }

        public int getIntValue(ByteOrder byteOrder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteOrder)) == null) {
                Object value = getValue(byteOrder);
                if (value != null) {
                    if (value instanceof String) {
                        return Integer.parseInt((String) value);
                    }
                    if (value instanceof long[]) {
                        long[] jArr = (long[]) value;
                        if (jArr.length == 1) {
                            return (int) jArr[0];
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else if (value instanceof int[]) {
                        int[] iArr = (int[]) value;
                        if (iArr.length == 1) {
                            return iArr[0];
                        }
                        throw new NumberFormatException("There are more than one component");
                    } else {
                        throw new NumberFormatException("Couldn't find a integer value");
                    }
                }
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            return invokeL.intValue;
        }

        public String getStringValue(ByteOrder byteOrder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteOrder)) == null) {
                Object value = getValue(byteOrder);
                if (value == null) {
                    return null;
                }
                if (value instanceof String) {
                    return (String) value;
                }
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    while (i2 < jArr.length) {
                        sb.append(jArr[i2]);
                        i2++;
                        if (i2 != jArr.length) {
                            sb.append(",");
                        }
                    }
                    return sb.toString();
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    while (i2 < iArr.length) {
                        sb.append(iArr[i2]);
                        i2++;
                        if (i2 != iArr.length) {
                            sb.append(",");
                        }
                    }
                    return sb.toString();
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    while (i2 < dArr.length) {
                        sb.append(dArr[i2]);
                        i2++;
                        if (i2 != dArr.length) {
                            sb.append(",");
                        }
                    }
                    return sb.toString();
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    while (i2 < rationalArr.length) {
                        sb.append(rationalArr[i2].numerator);
                        sb.append('/');
                        sb.append(rationalArr[i2].denominator);
                        i2++;
                        if (i2 != rationalArr.length) {
                            sb.append(",");
                        }
                    }
                    return sb.toString();
                } else {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        public Object getValue(ByteOrder byteOrder) {
            InterceptResult invokeL;
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            byte b2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, byteOrder)) != null) {
                return invokeL.objValue;
            }
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    boolean z = true;
                    int i2 = 0;
                    switch (this.format) {
                        case 1:
                        case 6:
                            if (this.bytes.length == 1 && this.bytes[0] >= 0 && this.bytes[0] <= 1) {
                                String str = new String(new char[]{(char) (this.bytes[0] + 48)});
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException unused) {
                                }
                                return str;
                            }
                            String str2 = new String(this.bytes, ExifInterface.ASCII);
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused2) {
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 < ExifInterface.EXIF_ASCII_PREFIX.length) {
                                        if (this.bytes[i3] != ExifInterface.EXIF_ASCII_PREFIX[i3]) {
                                            z = false;
                                        } else {
                                            i3++;
                                        }
                                    }
                                }
                                if (z) {
                                    i2 = ExifInterface.EXIF_ASCII_PREFIX.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i2 < this.numberOfComponents && (b2 = this.bytes[i2]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                i2++;
                            }
                            String sb2 = sb.toString();
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused3) {
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                iArr[i2] = byteOrderedDataInputStream.readUnsignedShort();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused4) {
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                jArr[i2] = byteOrderedDataInputStream.readUnsignedInt();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused5) {
                            }
                            return jArr;
                        case 5:
                            Rational[] rationalArr = new Rational[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                rationalArr[i2] = new Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused6) {
                            }
                            return rationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                iArr2[i2] = byteOrderedDataInputStream.readShort();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused7) {
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                iArr3[i2] = byteOrderedDataInputStream.readInt();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused8) {
                            }
                            return iArr3;
                        case 10:
                            Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                rationalArr2[i2] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused9) {
                            }
                            return rationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                dArr[i2] = byteOrderedDataInputStream.readFloat();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused10) {
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (i2 < this.numberOfComponents) {
                                dArr2[i2] = byteOrderedDataInputStream.readDouble();
                                i2++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused11) {
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException unused12) {
                            }
                            return null;
                    }
                } catch (IOException unused13) {
                    if (byteOrderedDataInputStream != null) {
                        try {
                            byteOrderedDataInputStream.close();
                        } catch (IOException unused14) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (byteOrderedDataInputStream2 != null) {
                        try {
                            byteOrderedDataInputStream2.close();
                        } catch (IOException unused15) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused16) {
                byteOrderedDataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public ExifAttribute(int i2, int i3, long j, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.format = i2;
            this.numberOfComponents = i3;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static ExifAttribute createDouble(double d2, ByteOrder byteOrder) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2), byteOrder})) == null) ? createDouble(new double[]{d2}, byteOrder) : (ExifAttribute) invokeCommon.objValue;
        }

        public static ExifAttribute createSLong(int i2, ByteOrder byteOrder) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, byteOrder)) == null) ? createSLong(new int[]{i2}, byteOrder) : (ExifAttribute) invokeIL.objValue;
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJL = interceptable.invokeJL(65546, null, j, byteOrder)) == null) ? createULong(new long[]{j}, byteOrder) : (ExifAttribute) invokeJL.objValue;
        }

        public static ExifAttribute createUShort(int i2, ByteOrder byteOrder) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i2, byteOrder)) == null) ? createUShort(new int[]{i2}, byteOrder) : (ExifAttribute) invokeIL.objValue;
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, rational, byteOrder)) == null) ? createSRational(new Rational[]{rational}, byteOrder) : (ExifAttribute) invokeLL.objValue;
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, rational, byteOrder)) == null) ? createURational(new Rational[]{rational}, byteOrder) : (ExifAttribute) invokeLL.objValue;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface IfdType {
    }

    /* loaded from: classes.dex */
    public static class Rational {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long denominator;
        public final long numerator;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Rational(double d2) {
            this((long) (d2 * 10000.0d), 10000L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public double calculate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.numerator / this.denominator : invokeV.doubleValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.numerator + "/" + this.denominator;
            }
            return (String) invokeV.objValue;
        }

        public Rational(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ExifTag[] exifTagArr;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1167787715, "Landroidx/exifinterface/media/ExifInterface;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1167787715, "Landroidx/exifinterface/media/ExifInterface;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
        ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
        FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_1 = new int[]{4};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, MARKER_SOI, -1};
        HEIF_TYPE_FTYP = new byte[]{102, 116, 121, 112};
        HEIF_BRAND_MIF1 = new byte[]{109, 105, 102, 49};
        HEIF_BRAND_HEIC = new byte[]{104, Constants.SHORT_PING_CMD_TYPE, 105, 99};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        PNG_SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_CHUNK_TYPE_EXIF = new byte[]{Constants.SHORT_PING_CMD_TYPE, 88, 73, 102};
        PNG_CHUNK_TYPE_IHDR = new byte[]{73, 72, 68, 82};
        PNG_CHUNK_TYPE_IEND = new byte[]{73, 69, 78, 68};
        WEBP_SIGNATURE_1 = new byte[]{82, 73, 70, 70};
        WEBP_SIGNATURE_2 = new byte[]{87, 69, 66, 80};
        WEBP_CHUNK_TYPE_EXIF = new byte[]{69, 88, 73, 70};
        WEBP_VP8_SIGNATURE = new byte[]{-99, 1, START_CODE};
        WEBP_CHUNK_TYPE_VP8X = WebpUtil.VP8X_HEADER.getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8L = WebpUtil.VP8L_HEADER.getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8 = WebpUtil.VP8_HEADER.getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_XMP = "XMP ".getBytes(Charset.defaultCharset());
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        IFD_TIFF_TAGS = new ExifTag[]{new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, PlayerEvent.PLAY_LOADING_END, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, AuthorityState.STATE_INIT_ING, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
        IFD_EXIF_TAGS = new ExifTag[]{new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, SendMsgDispatcher.LIMIT_SIZE, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_GPS_TAGS = new ExifTag[]{new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_INTEROPERABILITY_TAGS = new ExifTag[]{new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_THUMBNAIL_TAGS = new ExifTag[]{new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, PlayerEvent.PLAY_LOADING_END, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, AuthorityState.STATE_INIT_ING, 2), new ExifTag(TAG_STRIP_OFFSETS, 273, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, 273, 3);
        ORF_MAKER_NOTE_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_CAMERA_SETTINGS_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_IMAGE_PROCESSING_TAGS = new ExifTag[]{new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ExifTag[] exifTagArr2 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{exifTagArr3, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, exifTagArr3, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, exifTagArr2};
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        ExifTag[][] exifTagArr4 = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[exifTagArr4.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr4.length];
        sTagSetForCompatibility = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
        sExifPointerTagMap = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(ASCII);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            sExifTagMapsForReading[i2] = new HashMap<>();
            sExifTagMapsForWriting[i2] = new HashMap<>();
            for (ExifTag exifTag : EXIF_TAGS[i2]) {
                sExifTagMapsForReading[i2].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i2].put(exifTag.name, exifTag);
            }
        }
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), 5);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), 1);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), 2);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), 3);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), 7);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), 8);
        sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
        sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public ExifInterface(@NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
            if (attribute != null && getAttribute(TAG_DATETIME) == null) {
                this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
            }
            if (getAttribute(TAG_IMAGE_WIDTH) == null) {
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (getAttribute(TAG_IMAGE_LENGTH) == null) {
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (getAttribute(TAG_ORIENTATION) == null) {
                this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (getAttribute(TAG_LIGHT_SOURCE) == null) {
                this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, fileDescriptor) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Os.close(fileDescriptor);
        } catch (Exception unused) {
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    private String convertDecimalDegree(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Double.valueOf(d2)})) == null) {
            long j = (long) d2;
            double d3 = d2 - j;
            long j2 = (long) (d3 * 60.0d);
            long round = Math.round((d3 - (j2 / 60.0d)) * 3600.0d * 1.0E7d);
            return j + "/1," + j2 + "/1," + round + "/10000000";
        }
        return (String) invokeCommon.objValue;
    }

    public static double convertRationalLatLonToDouble(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            try {
                String[] split = str.split(",", -1);
                String[] split2 = split[0].split("/", -1);
                String[] split3 = split[1].split("/", -1);
                String[] split4 = split[2].split("/", -1);
                double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
                if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                        throw new IllegalArgumentException();
                    }
                    return parseDouble;
                }
                return -parseDouble;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
                throw new IllegalArgumentException();
            }
        }
        return invokeLL.doubleValue;
    }

    public static long[] convertToLongArray(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) {
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                long[] jArr = new long[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    jArr[i2] = iArr[i2];
                }
                return jArr;
            } else if (obj instanceof long[]) {
                return (long[]) obj;
            } else {
                return null;
            }
        }
        return (long[]) invokeL.objValue;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65550, null, inputStream, outputStream)) != null) {
            return invokeLL.intValue;
        }
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65552, this, byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr, bArr2) != null) {
            return;
        }
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                sb.append(new String(bArr, ASCII));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, ASCII);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr) == null) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.write(bArr);
            byteOrderedDataOutputStream.writeInt(readInt);
            if (readInt % 2 == 1) {
                readInt++;
            }
            copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
        }
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, str)) == null) {
            if (str != null) {
                if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                    boolean z = DEBUG;
                    str = TAG_PHOTOGRAPHIC_SENSITIVITY;
                }
                for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                    ExifAttribute exifAttribute = this.mAttributes[i2].get(str);
                    if (exifAttribute != null) {
                        return exifAttribute;
                    }
                }
                return null;
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return (ExifAttribute) invokeL.objValue;
    }

    private void getHeifAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, byteOrderedDataInputStream) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    mediaMetadataRetriever.setDataSource(new MediaDataSource(this, byteOrderedDataInputStream) { // from class: androidx.exifinterface.media.ExifInterface.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public long mPosition;
                        public final /* synthetic */ ExifInterface this$0;
                        public final /* synthetic */ ByteOrderedDataInputStream val$in;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, byteOrderedDataInputStream};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$in = byteOrderedDataInputStream;
                        }

                        @Override // java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            }
                        }

                        @Override // android.media.MediaDataSource
                        public long getSize() throws IOException {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return -1L;
                            }
                            return invokeV.longValue;
                        }

                        @Override // android.media.MediaDataSource
                        public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
                            InterceptResult invokeCommon;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                                if (i3 == 0) {
                                    return 0;
                                }
                                if (j < 0) {
                                    return -1;
                                }
                                try {
                                    if (this.mPosition != j) {
                                        if (this.mPosition >= 0 && j >= this.mPosition + this.val$in.available()) {
                                            return -1;
                                        }
                                        this.val$in.seek(j);
                                        this.mPosition = j;
                                    }
                                    if (i3 > this.val$in.available()) {
                                        i3 = this.val$in.available();
                                    }
                                    int read = this.val$in.read(bArr, i2, i3);
                                    if (read >= 0) {
                                        this.mPosition += read;
                                        return read;
                                    }
                                } catch (IOException unused) {
                                }
                                this.mPosition = -1L;
                                return -1;
                            }
                            return invokeCommon.intValue;
                        }
                    });
                } else if (this.mSeekableFileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(this.mSeekableFileDescriptor);
                } else if (this.mFilename == null) {
                    return;
                } else {
                    mediaMetadataRetriever.setDataSource(this.mFilename);
                }
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                String str3 = null;
                if ("yes".equals(extractMetadata3)) {
                    str3 = mediaMetadataRetriever.extractMetadata(29);
                    str = mediaMetadataRetriever.extractMetadata(30);
                    str2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str3 = mediaMetadataRetriever.extractMetadata(18);
                    str = mediaMetadataRetriever.extractMetadata(19);
                    str2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                }
                if (str3 != null) {
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createUShort(Integer.parseInt(str3), this.mExifByteOrder));
                }
                if (str != null) {
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createUShort(Integer.parseInt(str), this.mExifByteOrder));
                }
                if (str2 != null) {
                    int i2 = 1;
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt == 90) {
                        i2 = 6;
                    } else if (parseInt == 180) {
                        i2 = 3;
                    } else if (parseInt == 270) {
                        i2 = 8;
                    }
                    this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createUShort(i2, this.mExifByteOrder));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 > 6) {
                        byteOrderedDataInputStream.seek(parseInt2);
                        byte[] bArr = new byte[6];
                        if (byteOrderedDataInputStream.read(bArr) == 6) {
                            int i3 = parseInt2 + 6;
                            int i4 = parseInt3 - 6;
                            if (Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                                byte[] bArr2 = new byte[i4];
                                if (byteOrderedDataInputStream.read(bArr2) == i4) {
                                    this.mExifOffset = i3;
                                    readExifSegment(bArr2, 0);
                                } else {
                                    throw new IOException("Can't read exif");
                                }
                            } else {
                                throw new IOException("Invalid identifier");
                            }
                        } else {
                            throw new IOException("Can't read identifier");
                        }
                    } else {
                        throw new IOException("Invalid exif length");
                    }
                }
                if (DEBUG) {
                    String str4 = "Heif meta: " + str3 + "x" + str + ", rotation " + str2;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0192, code lost:
        r19.setByteOrder(r18.mExifByteOrder);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0197, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0186 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2, int i3) throws IOException {
        byte readByte;
        byte readByte2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLII(65556, this, byteOrderedDataInputStream, i2, i3) != null) {
            return;
        }
        if (DEBUG) {
            String str = "getJpegAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.seek(i2);
        byte b2 = -1;
        if (byteOrderedDataInputStream.readByte() == -1) {
            int i5 = 1;
            int i6 = i2 + 1;
            if (byteOrderedDataInputStream.readByte() != -40) {
                throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
            }
            int i7 = i6 + 1;
            while (true) {
                if (byteOrderedDataInputStream.readByte() == b2) {
                    int i8 = i7 + i5;
                    byte readByte3 = byteOrderedDataInputStream.readByte();
                    if (DEBUG) {
                        String str2 = "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255);
                    }
                    int i9 = i8 + i5;
                    if (readByte3 != -39 && readByte3 != -38) {
                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - 2;
                        int i10 = i9 + 2;
                        if (DEBUG) {
                            String str3 = "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + (readUnsignedShort + 2) + SmallTailInfo.EMOTION_SUFFIX;
                        }
                        if (readUnsignedShort < 0) {
                            throw new IOException("Invalid length");
                        }
                        if (readByte3 == -31) {
                            byte[] bArr = new byte[readUnsignedShort];
                            byteOrderedDataInputStream.readFully(bArr);
                            i4 = i10 + readUnsignedShort;
                            if (startsWith(bArr, IDENTIFIER_EXIF_APP1)) {
                                byte[] bArr2 = IDENTIFIER_EXIF_APP1;
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                                this.mExifOffset = i10 + bArr2.length;
                                readExifSegment(copyOfRange, i3);
                            } else if (startsWith(bArr, IDENTIFIER_XMP_APP1)) {
                                byte[] bArr3 = IDENTIFIER_XMP_APP1;
                                int length = i10 + bArr3.length;
                                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                                if (getAttribute(TAG_XMP) == null) {
                                    this.mAttributes[0].put(TAG_XMP, new ExifAttribute(1, copyOfRange2.length, length, copyOfRange2));
                                    this.mXmpIsFromSeparateMarker = true;
                                    readUnsignedShort = 0;
                                    if (readUnsignedShort >= 0) {
                                    }
                                }
                            }
                        } else if (readByte3 != -2) {
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                                default:
                                                    switch (readByte3) {
                                                    }
                                                case -55:
                                                case TbErrInfo.ERR_SEND_CANCEL /* -54 */:
                                                case TbErrInfo.ERR_SEND_FAIL /* -53 */:
                                                    if (byteOrderedDataInputStream.skipBytes(i5) == i5) {
                                                        this.mAttributes[i3].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                        this.mAttributes[i3].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                        readUnsignedShort -= 5;
                                                        break;
                                                    } else {
                                                        throw new IOException("Invalid SOFx");
                                                    }
                                            }
                                        case -59:
                                        case -58:
                                        case -57:
                                            break;
                                    }
                                case -64:
                                case -63:
                                case -62:
                                case -61:
                                    break;
                            }
                            i4 = i10;
                            if (readUnsignedShort >= 0) {
                                if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) != readUnsignedShort) {
                                    throw new IOException("Invalid JPEG segment");
                                }
                                i7 = i4 + readUnsignedShort;
                                b2 = -1;
                                i5 = 1;
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            byte[] bArr4 = new byte[readUnsignedShort];
                            if (byteOrderedDataInputStream.read(bArr4) == readUnsignedShort) {
                                if (getAttribute(TAG_USER_COMMENT) == null) {
                                    this.mAttributes[i5].put(TAG_USER_COMMENT, ExifAttribute.createString(new String(bArr4, ASCII)));
                                }
                                i4 = i10;
                            } else {
                                throw new IOException("Invalid exif");
                            }
                        }
                        readUnsignedShort = 0;
                        if (readUnsignedShort >= 0) {
                        }
                    }
                } else {
                    throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                }
            }
        } else {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, bufferedInputStream)) == null) {
            bufferedInputStream.mark(5000);
            byte[] bArr = new byte[5000];
            bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            if (isJpegFormat(bArr)) {
                return 4;
            }
            if (isRafFormat(bArr)) {
                return 9;
            }
            if (isHeifFormat(bArr)) {
                return 12;
            }
            if (isOrfFormat(bArr)) {
                return 7;
            }
            if (isRw2Format(bArr)) {
                return 10;
            }
            if (isPngFormat(bArr)) {
                return 13;
            }
            return isWebpFormat(bArr) ? 14 : 0;
        }
        return invokeL.intValue;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, byteOrderedDataInputStream) == null) {
            getRawAttributes(byteOrderedDataInputStream);
            ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
            if (exifAttribute != null) {
                ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
                byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
                byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_1.length];
                byteOrderedDataInputStream2.readFully(bArr);
                byteOrderedDataInputStream2.seek(0L);
                byte[] bArr2 = new byte[ORF_MAKER_NOTE_HEADER_2.length];
                byteOrderedDataInputStream2.readFully(bArr2);
                if (Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_1)) {
                    byteOrderedDataInputStream2.seek(8L);
                } else if (Arrays.equals(bArr2, ORF_MAKER_NOTE_HEADER_2)) {
                    byteOrderedDataInputStream2.seek(12L);
                }
                readImageFileDirectory(byteOrderedDataInputStream2, 6);
                ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                if (exifAttribute2 != null && exifAttribute3 != null) {
                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                    this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
                }
                ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
                if (exifAttribute4 != null) {
                    int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                    if (iArr != null && iArr.length == 4) {
                        if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                            return;
                        }
                        int i2 = (iArr[2] - iArr[0]) + 1;
                        int i3 = (iArr[3] - iArr[1]) + 1;
                        if (i2 < i3) {
                            int i4 = i2 + i3;
                            i3 = i4 - i3;
                            i2 = i4 - i3;
                        }
                        ExifAttribute createUShort = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                        ExifAttribute createUShort2 = ExifAttribute.createUShort(i3, this.mExifByteOrder);
                        this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                        this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                        return;
                    }
                    String str = "Invalid aspect frame values. frame=" + Arrays.toString(iArr);
                }
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65559, this, byteOrderedDataInputStream) != null) {
            return;
        }
        if (DEBUG) {
            String str = "getPngAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.skipBytes(PNG_SIGNATURE.length);
        int length = PNG_SIGNATURE.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i2 = length + 4;
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16 && !Arrays.equals(bArr, PNG_CHUNK_TYPE_IHDR)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (Arrays.equals(bArr, PNG_CHUNK_TYPE_IEND)) {
                        return;
                    }
                    if (Arrays.equals(bArr, PNG_CHUNK_TYPE_EXIF)) {
                        byte[] bArr2 = new byte[readInt];
                        if (byteOrderedDataInputStream.read(bArr2) == readInt) {
                            int readInt2 = byteOrderedDataInputStream.readInt();
                            CRC32 crc32 = new CRC32();
                            crc32.update(bArr);
                            crc32.update(bArr2);
                            if (((int) crc32.getValue()) == readInt2) {
                                this.mExifOffset = i3;
                                readExifSegment(bArr2, 0);
                                validateImages();
                                return;
                            }
                            throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                    }
                    int i4 = readInt + 4;
                    byteOrderedDataInputStream.skipBytes(i4);
                    length = i3 + i4;
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, byteOrderedDataInputStream) == null) {
            byteOrderedDataInputStream.skipBytes(84);
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[4];
            byteOrderedDataInputStream.read(bArr);
            byteOrderedDataInputStream.skipBytes(4);
            byteOrderedDataInputStream.read(bArr2);
            int i2 = ByteBuffer.wrap(bArr).getInt();
            int i3 = ByteBuffer.wrap(bArr2).getInt();
            getJpegAttributes(byteOrderedDataInputStream, i2, 5);
            byteOrderedDataInputStream.seek(i3);
            byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
            int readInt = byteOrderedDataInputStream.readInt();
            if (DEBUG) {
                String str = "numberOfDirectoryEntry: " + readInt;
            }
            for (int i4 = 0; i4 < readInt; i4++) {
                int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                    short readShort = byteOrderedDataInputStream.readShort();
                    short readShort2 = byteOrderedDataInputStream.readShort();
                    ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                    if (DEBUG) {
                        String str2 = "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2);
                        return;
                    }
                    return;
                }
                byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
            }
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, byteOrderedDataInputStream) == null) {
            parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
            readImageFileDirectory(byteOrderedDataInputStream, 0);
            updateImageSizeValues(byteOrderedDataInputStream, 0);
            updateImageSizeValues(byteOrderedDataInputStream, 5);
            updateImageSizeValues(byteOrderedDataInputStream, 4);
            validateImages();
            if (this.mMimeType != 8 || (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) == null) {
                return;
            }
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byteOrderedDataInputStream2.seek(6L);
            readImageFileDirectory(byteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, byteOrderedDataInputStream) == null) {
            getRawAttributes(byteOrderedDataInputStream);
            if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
                getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
            }
            ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_ISO);
            ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
            if (exifAttribute == null || exifAttribute2 != null) {
                return;
            }
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
        }
    }

    private void getStandaloneAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, byteOrderedDataInputStream) == null) {
            byteOrderedDataInputStream.skipBytes(IDENTIFIER_EXIF_APP1.length);
            byte[] bArr = new byte[byteOrderedDataInputStream.available()];
            byteOrderedDataInputStream.readFully(bArr);
            this.mExifOffset = IDENTIFIER_EXIF_APP1.length;
            readExifSegment(bArr, 0);
        }
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65564, this, byteOrderedDataInputStream) != null) {
            return;
        }
        if (DEBUG) {
            r0 = "getWebpAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        int skipBytes = byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i2 = skipBytes + 4 + 4;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr2) == readInt2) {
                            this.mExifOffset = i2;
                            readExifSegment(bArr2, 0);
                            this.mExifOffset = i2;
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i3 = i2 + readInt2;
                    if (i3 == readInt) {
                        return;
                    }
                    if (i3 <= readInt) {
                        int skipBytes2 = byteOrderedDataInputStream.skipBytes(readInt2);
                        if (skipBytes2 != readInt2) {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                        skipBytes = i2 + skipBytes2;
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public static Pair<Integer, Integer> guessDataFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (str.contains(",")) {
                String[] split = str.split(",", -1);
                Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
                if (((Integer) guessDataFormat.first).intValue() == 2) {
                    return guessDataFormat;
                }
                for (int i2 = 1; i2 < split.length; i2++) {
                    Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i2]);
                    int intValue = (((Integer) guessDataFormat2.first).equals(guessDataFormat.first) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.first)) ? ((Integer) guessDataFormat.first).intValue() : -1;
                    int intValue2 = (((Integer) guessDataFormat.second).intValue() == -1 || !(((Integer) guessDataFormat2.first).equals(guessDataFormat.second) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.second))) ? -1 : ((Integer) guessDataFormat.second).intValue();
                    if (intValue == -1 && intValue2 == -1) {
                        return new Pair<>(2, -1);
                    }
                    if (intValue == -1) {
                        guessDataFormat = new Pair<>(Integer.valueOf(intValue2), -1);
                    } else if (intValue2 == -1) {
                        guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                    }
                }
                return guessDataFormat;
            } else if (str.contains("/")) {
                String[] split2 = str.split("/", -1);
                if (split2.length == 2) {
                    try {
                        long parseDouble = (long) Double.parseDouble(split2[0]);
                        long parseDouble2 = (long) Double.parseDouble(split2[1]);
                        if (parseDouble >= 0 && parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                                return new Pair<>(10, 5);
                            }
                            return new Pair<>(5, -1);
                        }
                        return new Pair<>(10, -1);
                    } catch (NumberFormatException unused) {
                    }
                }
                return new Pair<>(2, -1);
            } else {
                try {
                    try {
                        Long valueOf = Long.valueOf(Long.parseLong(str));
                        if (valueOf.longValue() >= 0 && valueOf.longValue() <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                            return new Pair<>(3, 4);
                        }
                        if (valueOf.longValue() < 0) {
                            return new Pair<>(9, -1);
                        }
                        return new Pair<>(4, -1);
                    } catch (NumberFormatException unused2) {
                        return new Pair<>(2, -1);
                    }
                } catch (NumberFormatException unused3) {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                }
            }
        }
        return (Pair) invokeL.objValue;
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, this, byteOrderedDataInputStream, hashMap) == null) {
            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifAttribute == null || exifAttribute2 == null) {
                return;
            }
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            int min = Math.min(intValue2, byteOrderedDataInputStream.getLength() - intValue);
            if (intValue > 0 && min > 0) {
                this.mHasThumbnail = true;
                int i2 = this.mExifOffset + intValue;
                this.mThumbnailOffset = i2;
                this.mThumbnailLength = min;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[min];
                    byteOrderedDataInputStream.seek(i2);
                    byteOrderedDataInputStream.readFully(bArr);
                    this.mThumbnailBytes = bArr;
                }
            }
            if (DEBUG) {
                String str = "Setting thumbnail attributes with offset: " + intValue + ", length: " + min;
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, this, byteOrderedDataInputStream, hashMap) == null) {
            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
            if (exifAttribute == null || exifAttribute2 == null) {
                return;
            }
            long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray == null || convertToLongArray.length == 0 || convertToLongArray2 == null || convertToLongArray2.length == 0 || convertToLongArray.length != convertToLongArray2.length) {
                return;
            }
            long j = 0;
            for (long j2 : convertToLongArray2) {
                j += j2;
            }
            int i2 = (int) j;
            byte[] bArr = new byte[i2];
            this.mAreThumbnailStripsConsecutive = true;
            this.mHasThumbnailStrips = true;
            this.mHasThumbnail = true;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < convertToLongArray.length; i5++) {
                int i6 = (int) convertToLongArray[i5];
                int i7 = (int) convertToLongArray2[i5];
                if (i5 < convertToLongArray.length - 1 && i6 + i7 != convertToLongArray[i5 + 1]) {
                    this.mAreThumbnailStripsConsecutive = false;
                }
                int i8 = i6 - i3;
                byteOrderedDataInputStream.seek(i8);
                int i9 = i3 + i8;
                byte[] bArr2 = new byte[i7];
                byteOrderedDataInputStream.read(bArr2);
                i3 = i9 + i7;
                System.arraycopy(bArr2, 0, bArr, i4, i7);
                i4 += i7;
            }
            this.mThumbnailBytes = bArr;
            if (this.mAreThumbnailStripsConsecutive) {
                this.mThumbnailOffset = ((int) convertToLongArray[0]) + this.mExifOffset;
                this.mThumbnailLength = i2;
            }
        }
    }

    private void initForFilename(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65568, this, str) != null) {
            return;
        }
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65569, null, bufferedInputStream)) != null) {
            return invokeL.booleanValue;
        }
        bufferedInputStream.mark(IDENTIFIER_EXIF_APP1.length);
        byte[] bArr = new byte[IDENTIFIER_EXIF_APP1.length];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = IDENTIFIER_EXIF_APP1;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean isHeifFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, bArr)) == null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
            try {
                try {
                    byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                readInt = byteOrderedDataInputStream.readInt();
                bArr2 = new byte[4];
                byteOrderedDataInputStream.read(bArr2);
            } catch (Exception unused2) {
                byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                boolean z = DEBUG;
                if (byteOrderedDataInputStream2 != null) {
                    byteOrderedDataInputStream2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                if (byteOrderedDataInputStream2 != null) {
                    byteOrderedDataInputStream2.close();
                }
                throw th;
            }
            if (!Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
                byteOrderedDataInputStream.close();
                return false;
            }
            long j = 16;
            if (readInt == 1) {
                readInt = byteOrderedDataInputStream.readLong();
                if (readInt < 16) {
                    byteOrderedDataInputStream.close();
                    return false;
                }
            } else {
                j = 8;
            }
            if (readInt > bArr.length) {
                readInt = bArr.length;
            }
            long j2 = readInt - j;
            if (j2 < 8) {
                byteOrderedDataInputStream.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z2 = false;
            boolean z3 = false;
            for (long j3 = 0; j3 < j2 / 4; j3++) {
                if (byteOrderedDataInputStream.read(bArr3) != 4) {
                    byteOrderedDataInputStream.close();
                    return false;
                }
                if (j3 != 1) {
                    if (Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                        z2 = true;
                    } else if (Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        byteOrderedDataInputStream.close();
                        return true;
                    }
                }
            }
            byteOrderedDataInputStream.close();
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isJpegFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65571, null, bArr)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65572, this, bArr)) != null) {
            return invokeL.booleanValue;
        }
        boolean z = false;
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                short readShort = byteOrderedDataInputStream2.readShort();
                z = (readShort == 20306 || readShort == 21330) ? true : true;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65573, this, bArr)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, bArr)) == null) {
            byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
            for (int i2 = 0; i2 < bytes.length; i2++) {
                if (bArr[i2] != bytes[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isRw2Format(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65575, this, bArr)) != null) {
            return invokeL.booleanValue;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = null;
        try {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
            try {
                ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream2);
                this.mExifByteOrder = readByteOrder;
                byteOrderedDataInputStream2.setByteOrder(readByteOrder);
                boolean z = byteOrderedDataInputStream2.readShort() == 85;
                byteOrderedDataInputStream2.close();
                return z;
            } catch (Exception unused) {
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                byteOrderedDataInputStream = byteOrderedDataInputStream2;
                if (byteOrderedDataInputStream != null) {
                    byteOrderedDataInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, fileDescriptor)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
                    return true;
                } catch (Exception unused) {
                    boolean z = DEBUG;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        InterceptResult invokeL;
        ExifAttribute exifAttribute;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, this, hashMap)) == null) {
            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
            if (exifAttribute2 != null) {
                int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
                if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                    return true;
                }
                if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB)))) {
                    return true;
                }
            }
            boolean z = DEBUG;
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSupportedFormatForSavingAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            if (this.mIsSupportedFile) {
                int i2 = this.mMimeType;
                return i2 == 4 || i2 == 13 || i2 == 14;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            if (str != null) {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                char c2 = 65535;
                switch (lowerCase.hashCode()) {
                    case -1875291391:
                        if (lowerCase.equals("image/x-fuji-raf")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -1635437028:
                        if (lowerCase.equals("image/x-samsung-srw")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -1594371159:
                        if (lowerCase.equals("image/x-sony-arw")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1487464693:
                        if (lowerCase.equals("image/heic")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -1487464690:
                        if (lowerCase.equals("image/heif")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -1487394660:
                        if (lowerCase.equals("image/jpeg")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1487018032:
                        if (lowerCase.equals("image/webp")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case -1423313290:
                        if (lowerCase.equals("image/x-adobe-dng")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -985160897:
                        if (lowerCase.equals("image/x-panasonic-rw2")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -879258763:
                        if (lowerCase.equals("image/png")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                    case -332763809:
                        if (lowerCase.equals("image/x-pentax-pef")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1378106698:
                        if (lowerCase.equals("image/x-olympus-orf")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 2099152104:
                        if (lowerCase.equals("image/x-nikon-nef")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 2099152524:
                        if (lowerCase.equals("image/x-nikon-nrw")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 2111234748:
                        if (lowerCase.equals("image/x-canon-cr2")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                        return true;
                    default:
                        return false;
                }
            }
            throw new NullPointerException("mimeType shouldn't be null");
        }
        return invokeL.booleanValue;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, this, hashMap)) == null) {
            ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
            if (exifAttribute == null || exifAttribute2 == null) {
                return false;
            }
            return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
        }
        return invokeL.booleanValue;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65581, this, bArr)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i2 >= bArr2.length) {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i3 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i3 + 4] != bArr3[i3]) {
                        return false;
                    }
                    i3++;
                }
            } else if (bArr[i2] != bArr2[i2]) {
                return false;
            } else {
                i2++;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, SGET]}, finally: {[INVOKE, SGET, INVOKE, IF] complete} */
    private void loadAttributes(@NonNull InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, this, inputStream) == null) {
            if (inputStream != null) {
                for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                    try {
                        try {
                            this.mAttributes[i2] = new HashMap<>();
                        } catch (IOException unused) {
                            this.mIsSupportedFile = false;
                            boolean z = DEBUG;
                            addDefaultValuesForCompatibility();
                            if (!DEBUG) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                        }
                        throw th;
                    }
                }
                if (!this.mIsExifDataOnly) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                    this.mMimeType = getMimeType(bufferedInputStream);
                    inputStream = bufferedInputStream;
                }
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                if (!this.mIsExifDataOnly) {
                    switch (this.mMimeType) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 11:
                            getRawAttributes(byteOrderedDataInputStream);
                            break;
                        case 4:
                            getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                            break;
                        case 7:
                            getOrfAttributes(byteOrderedDataInputStream);
                            break;
                        case 9:
                            getRafAttributes(byteOrderedDataInputStream);
                            break;
                        case 10:
                            getRw2Attributes(byteOrderedDataInputStream);
                            break;
                        case 12:
                            getHeifAttributes(byteOrderedDataInputStream);
                            break;
                        case 13:
                            getPngAttributes(byteOrderedDataInputStream);
                            break;
                        case 14:
                            getWebpAttributes(byteOrderedDataInputStream);
                            break;
                    }
                } else {
                    getStandaloneAttributes(byteOrderedDataInputStream);
                }
                setThumbnailData(byteOrderedDataInputStream);
                this.mIsSupportedFile = true;
                addDefaultValuesForCompatibility();
                if (!DEBUG) {
                    return;
                }
                printAttributes();
                return;
            }
            throw new NullPointerException("inputstream shouldn't be null");
        }
    }

    public static long parseDateTime(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, null, str, str2)) == null) {
            if (str != null && sNonZeroTimePattern.matcher(str).matches()) {
                try {
                    Date parse = sFormatter.parse(str, new ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    long time = parse.getTime();
                    if (str2 != null) {
                        try {
                            long parseLong = Long.parseLong(str2);
                            while (parseLong > 1000) {
                                parseLong /= 10;
                            }
                            return time + parseLong;
                        } catch (NumberFormatException unused) {
                            return time;
                        }
                    }
                    return time;
                } catch (IllegalArgumentException unused2) {
                }
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65584, this, byteOrderedDataInputStream, i2) == null) {
            ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
            this.mExifByteOrder = readByteOrder;
            byteOrderedDataInputStream.setByteOrder(readByteOrder);
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int i3 = this.mMimeType;
            if (i3 != 7 && i3 != 10 && readUnsignedShort != 42) {
                throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
            }
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8 && readInt < i2) {
                int i4 = readInt - 8;
                if (i4 <= 0 || byteOrderedDataInputStream.skipBytes(i4) == i4) {
                    return;
                }
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
    }

    private void printAttributes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            for (int i2 = 0; i2 < this.mAttributes.length; i2++) {
                String str = "The size of tag group[" + i2 + "]: " + this.mAttributes[i2].size();
                for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[i2].entrySet()) {
                    ExifAttribute value = entry.getValue();
                    String str2 = "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.mExifByteOrder) + "'";
                }
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, this, byteOrderedDataInputStream)) == null) {
            short readShort = byteOrderedDataInputStream.readShort();
            if (readShort == 18761) {
                boolean z = DEBUG;
                return ByteOrder.LITTLE_ENDIAN;
            } else if (readShort == 19789) {
                boolean z2 = DEBUG;
                return ByteOrder.BIG_ENDIAN;
            } else {
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
            }
        }
        return (ByteOrder) invokeL.objValue;
    }

    private void readExifSegment(byte[] bArr, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65587, this, bArr, i2) == null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
            parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
            readImageFileDirectory(byteOrderedDataInputStream, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readImageFileDirectory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        short s;
        ExifTag exifTag;
        long j;
        boolean z;
        long j2;
        int i3;
        ExifTag exifTag2;
        short s2;
        long j3;
        int readUnsignedShort;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65588, this, byteOrderedDataInputStream, i2) == null) {
            int i4 = i2;
            this.mAttributesOffsets.add(Integer.valueOf(byteOrderedDataInputStream.mPosition));
            if (byteOrderedDataInputStream.mPosition + 2 > byteOrderedDataInputStream.mLength) {
                return;
            }
            short readShort = byteOrderedDataInputStream.readShort();
            if (DEBUG) {
                String str = "numberOfDirectoryEntry: " + ((int) readShort);
            }
            if (byteOrderedDataInputStream.mPosition + (readShort * 12) > byteOrderedDataInputStream.mLength || readShort <= 0) {
                return;
            }
            char c2 = 0;
            short s3 = 0;
            while (s3 < readShort) {
                int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                int readUnsignedShort3 = byteOrderedDataInputStream.readUnsignedShort();
                int readInt = byteOrderedDataInputStream.readInt();
                long peek = byteOrderedDataInputStream.peek() + 4;
                ExifTag exifTag3 = sExifTagMapsForReading[i4].get(Integer.valueOf(readUnsignedShort2));
                if (DEBUG) {
                    Object[] objArr = new Object[5];
                    objArr[c2] = Integer.valueOf(i2);
                    objArr[1] = Integer.valueOf(readUnsignedShort2);
                    objArr[2] = exifTag3 != null ? exifTag3.name : null;
                    objArr[3] = Integer.valueOf(readUnsignedShort3);
                    objArr[4] = Integer.valueOf(readInt);
                    String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
                }
                if (exifTag3 == null) {
                    if (DEBUG) {
                        String str2 = "Skip the tag entry since tag number is not defined: " + readUnsignedShort2;
                    }
                } else if (readUnsignedShort3 > 0 && readUnsignedShort3 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                    if (!exifTag3.isFormatCompatible(readUnsignedShort3)) {
                        if (DEBUG) {
                            String str3 = "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[readUnsignedShort3] + ") is unexpected for tag: " + exifTag3.name;
                        }
                    } else {
                        if (readUnsignedShort3 == 7) {
                            readUnsignedShort3 = exifTag3.primaryFormat;
                        }
                        s = s3;
                        exifTag = exifTag3;
                        j = readInt * IFD_FORMAT_BYTES_PER_FORMAT[readUnsignedShort3];
                        if (j < 0 || j > 2147483647L) {
                            if (DEBUG) {
                                String str4 = "Skip the tag entry since the number of components is invalid: " + readInt;
                            }
                            z = false;
                            if (z) {
                            }
                            s3 = (short) (s + 1);
                            i4 = i2;
                            readShort = s2;
                            c2 = 0;
                        } else {
                            z = true;
                            if (z) {
                            }
                            s3 = (short) (s + 1);
                            i4 = i2;
                            readShort = s2;
                            c2 = 0;
                        }
                    }
                } else {
                    s = s3;
                    exifTag = exifTag3;
                    if (DEBUG) {
                        String str5 = "Skip the tag entry since data format is invalid: " + readUnsignedShort3;
                    }
                    j = 0;
                    z = false;
                    if (z) {
                        byteOrderedDataInputStream.seek(peek);
                        s2 = readShort;
                    } else {
                        if (j > 4) {
                            int readInt2 = byteOrderedDataInputStream.readInt();
                            if (DEBUG) {
                                String str6 = "seek to data offset: " + readInt2;
                            }
                            int i5 = this.mMimeType;
                            if (i5 == 7) {
                                exifTag2 = exifTag;
                                if (TAG_MAKER_NOTE.equals(exifTag2.name)) {
                                    this.mOrfMakerNoteOffset = readInt2;
                                } else if (i4 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifTag2.name)) {
                                    this.mOrfThumbnailOffset = readInt2;
                                    this.mOrfThumbnailLength = readInt;
                                    ExifAttribute createUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                    i3 = readInt;
                                    s2 = readShort;
                                    ExifAttribute createULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                    ExifAttribute createULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                    this.mAttributes[4].put(TAG_COMPRESSION, createUShort);
                                    this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, createULong);
                                    this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, createULong2);
                                }
                                s2 = readShort;
                                i3 = readInt;
                            } else {
                                i3 = readInt;
                                exifTag2 = exifTag;
                                s2 = readShort;
                                if (i5 == 10 && TAG_RW2_JPG_FROM_RAW.equals(exifTag2.name)) {
                                    this.mRw2JpgFromRawOffset = readInt2;
                                }
                            }
                            long j4 = readInt2;
                            j2 = j;
                            if (j4 + j <= byteOrderedDataInputStream.mLength) {
                                byteOrderedDataInputStream.seek(j4);
                            } else {
                                if (DEBUG) {
                                    String str7 = "Skip the tag entry since data offset is invalid: " + readInt2;
                                }
                                byteOrderedDataInputStream.seek(peek);
                            }
                        } else {
                            j2 = j;
                            i3 = readInt;
                            exifTag2 = exifTag;
                            s2 = readShort;
                        }
                        Integer num = sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort2));
                        if (DEBUG) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("nextIfdType: ");
                            sb.append(num);
                            sb.append(" byteCount: ");
                            j3 = j2;
                            sb.append(j3);
                            sb.toString();
                        } else {
                            j3 = j2;
                        }
                        if (num != null) {
                            long j5 = -1;
                            if (readUnsignedShort3 == 3) {
                                readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                            } else {
                                if (readUnsignedShort3 == 4) {
                                    j5 = byteOrderedDataInputStream.readUnsignedInt();
                                } else if (readUnsignedShort3 == 8) {
                                    readUnsignedShort = byteOrderedDataInputStream.readShort();
                                } else if (readUnsignedShort3 == 9 || readUnsignedShort3 == 13) {
                                    readUnsignedShort = byteOrderedDataInputStream.readInt();
                                }
                                if (DEBUG) {
                                    String.format("Offset: %d, tagName: %s", Long.valueOf(j5), exifTag2.name);
                                }
                                if (j5 <= 0 && j5 < byteOrderedDataInputStream.mLength) {
                                    if (!this.mAttributesOffsets.contains(Integer.valueOf((int) j5))) {
                                        byteOrderedDataInputStream.seek(j5);
                                        readImageFileDirectory(byteOrderedDataInputStream, num.intValue());
                                    } else if (DEBUG) {
                                        String str8 = "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j5 + SmallTailInfo.EMOTION_SUFFIX;
                                    }
                                } else if (DEBUG) {
                                    String str9 = "Skip jump into the IFD since its offset is invalid: " + j5;
                                }
                                byteOrderedDataInputStream.seek(peek);
                            }
                            j5 = readUnsignedShort;
                            if (DEBUG) {
                            }
                            if (j5 <= 0) {
                            }
                            if (DEBUG) {
                            }
                            byteOrderedDataInputStream.seek(peek);
                        } else {
                            int peek2 = byteOrderedDataInputStream.peek() + this.mExifOffset;
                            byte[] bArr = new byte[(int) j3];
                            byteOrderedDataInputStream.readFully(bArr);
                            ExifAttribute exifAttribute = new ExifAttribute(readUnsignedShort3, i3, peek2, bArr);
                            this.mAttributes[i2].put(exifTag2.name, exifAttribute);
                            if (TAG_DNG_VERSION.equals(exifTag2.name)) {
                                this.mMimeType = 3;
                            }
                            if (((TAG_MAKE.equals(exifTag2.name) || TAG_MODEL.equals(exifTag2.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || (TAG_COMPRESSION.equals(exifTag2.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                this.mMimeType = 8;
                            }
                            if (byteOrderedDataInputStream.peek() != peek) {
                                byteOrderedDataInputStream.seek(peek);
                            }
                        }
                        s3 = (short) (s + 1);
                        i4 = i2;
                        readShort = s2;
                        c2 = 0;
                    }
                    s3 = (short) (s + 1);
                    i4 = i2;
                    readShort = s2;
                    c2 = 0;
                }
                s = s3;
                exifTag = exifTag3;
                j = 0;
                z = false;
                if (z) {
                }
                s3 = (short) (s + 1);
                i4 = i2;
                readShort = s2;
                c2 = 0;
            }
            if (byteOrderedDataInputStream.peek() + 4 <= byteOrderedDataInputStream.mLength) {
                int readInt3 = byteOrderedDataInputStream.readInt();
                if (DEBUG) {
                    String.format("nextIfdOffset: %d", Integer.valueOf(readInt3));
                }
                long j6 = readInt3;
                if (j6 > 0 && readInt3 < byteOrderedDataInputStream.mLength) {
                    if (!this.mAttributesOffsets.contains(Integer.valueOf(readInt3))) {
                        byteOrderedDataInputStream.seek(j6);
                        if (this.mAttributes[4].isEmpty()) {
                            readImageFileDirectory(byteOrderedDataInputStream, 4);
                        } else if (this.mAttributes[5].isEmpty()) {
                            readImageFileDirectory(byteOrderedDataInputStream, 5);
                        }
                    } else if (DEBUG) {
                        String str10 = "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3;
                    }
                } else if (DEBUG) {
                    String str11 = "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3;
                }
            }
        }
    }

    private void removeAttribute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, this, str) == null) {
            for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                this.mAttributes[i2].remove(str);
            }
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65590, this, byteOrderedDataInputStream, i2) == null) {
            ExifAttribute exifAttribute2 = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
            if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.mAttributes[i2].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
                getJpegAttributes(byteOrderedDataInputStream, exifAttribute.getIntValue(this.mExifByteOrder), i2);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65591, this, inputStream, outputStream) == null) {
            if (DEBUG) {
                String str = "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + SmallTailInfo.EMOTION_SUFFIX;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
            if (dataInputStream.readByte() == -1) {
                byteOrderedDataOutputStream.writeByte(-1);
                if (dataInputStream.readByte() == -40) {
                    byteOrderedDataOutputStream.writeByte(-40);
                    ExifAttribute exifAttribute = null;
                    if (getAttribute(TAG_XMP) != null && this.mXmpIsFromSeparateMarker) {
                        exifAttribute = this.mAttributes[0].remove(TAG_XMP);
                    }
                    byteOrderedDataOutputStream.writeByte(-1);
                    byteOrderedDataOutputStream.writeByte(-31);
                    writeExifSegment(byteOrderedDataOutputStream);
                    if (exifAttribute != null) {
                        this.mAttributes[0].put(TAG_XMP, exifAttribute);
                    }
                    byte[] bArr = new byte[4096];
                    while (dataInputStream.readByte() == -1) {
                        byte readByte = dataInputStream.readByte();
                        if (readByte == -39 || readByte == -38) {
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            copy(dataInputStream, byteOrderedDataOutputStream);
                            return;
                        } else if (readByte != -31) {
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            int readUnsignedShort = dataInputStream.readUnsignedShort();
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                            int i2 = readUnsignedShort - 2;
                            if (i2 < 0) {
                                throw new IOException("Invalid length");
                            }
                            while (i2 > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                if (read >= 0) {
                                    byteOrderedDataOutputStream.write(bArr, 0, read);
                                    i2 -= read;
                                }
                            }
                        } else {
                            int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                            if (readUnsignedShort2 >= 0) {
                                byte[] bArr2 = new byte[6];
                                if (readUnsignedShort2 >= 6) {
                                    if (dataInputStream.read(bArr2) == 6) {
                                        if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                            int i3 = readUnsignedShort2 - 6;
                                            if (dataInputStream.skipBytes(i3) != i3) {
                                                throw new IOException("Invalid length");
                                            }
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                byteOrderedDataOutputStream.writeByte(-1);
                                byteOrderedDataOutputStream.writeByte(readByte);
                                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                                if (readUnsignedShort2 >= 6) {
                                    readUnsignedShort2 -= 6;
                                    byteOrderedDataOutputStream.write(bArr2);
                                }
                                while (readUnsignedShort2 > 0) {
                                    int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                    if (read2 >= 0) {
                                        byteOrderedDataOutputStream.write(bArr, 0, read2);
                                        readUnsignedShort2 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    }
                    throw new IOException("Invalid marker");
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65592, this, inputStream, outputStream) == null) {
            if (DEBUG) {
                String str = "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + SmallTailInfo.EMOTION_SUFFIX;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
            copy(dataInputStream, byteOrderedDataOutputStream, PNG_SIGNATURE.length);
            int i2 = this.mExifOffset;
            if (i2 == 0) {
                int readInt = dataInputStream.readInt();
                byteOrderedDataOutputStream.writeInt(readInt);
                copy(dataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
            } else {
                copy(dataInputStream, byteOrderedDataOutputStream, ((i2 - PNG_SIGNATURE.length) - 4) - 4);
                dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream, ByteOrder.BIG_ENDIAN);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                closeQuietly(byteArrayOutputStream);
                copy(dataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                closeQuietly(byteArrayOutputStream2);
                throw th;
            }
        }
    }

    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, this, inputStream, outputStream) == null) {
            if (DEBUG) {
                String str = "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + SmallTailInfo.EMOTION_SUFFIX;
            }
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
            ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.LITTLE_ENDIAN);
            copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, WEBP_SIGNATURE_1.length);
            byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length + 4);
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream, ByteOrder.LITTLE_ENDIAN);
                if (this.mExifOffset != 0) {
                    copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, ((this.mExifOffset - ((WEBP_SIGNATURE_1.length + 4) + WEBP_SIGNATURE_2.length)) - 4) - 4);
                    byteOrderedDataInputStream.skipBytes(4);
                    byteOrderedDataInputStream.skipBytes(byteOrderedDataInputStream.readInt());
                    writeExifSegment(byteOrderedDataOutputStream2);
                } else {
                    byte[] bArr = new byte[4];
                    if (byteOrderedDataInputStream.read(bArr) == 4) {
                        if (Arrays.equals(bArr, WEBP_CHUNK_TYPE_VP8X)) {
                            int readInt = byteOrderedDataInputStream.readInt();
                            boolean z = true;
                            byte[] bArr2 = new byte[readInt % 2 == 1 ? readInt + 1 : readInt];
                            byteOrderedDataInputStream.read(bArr2);
                            bArr2[0] = (byte) (bArr2[0] | 8);
                            if (((bArr2[0] >> 1) & 1) != 1) {
                                z = false;
                            }
                            byteOrderedDataOutputStream2.write(WEBP_CHUNK_TYPE_VP8X);
                            byteOrderedDataOutputStream2.writeInt(readInt);
                            byteOrderedDataOutputStream2.write(bArr2);
                            if (z) {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, null);
                                while (true) {
                                    byte[] bArr3 = new byte[4];
                                    inputStream.read(bArr3);
                                    if (!Arrays.equals(bArr3, WEBP_CHUNK_TYPE_ANMF)) {
                                        break;
                                    }
                                    copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr3);
                                }
                                writeExifSegment(byteOrderedDataOutputStream2);
                            } else {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                writeExifSegment(byteOrderedDataOutputStream2);
                            }
                        } else if (Arrays.equals(bArr, WEBP_CHUNK_TYPE_VP8) || Arrays.equals(bArr, WEBP_CHUNK_TYPE_VP8L)) {
                            throw new IOException("WebP files with only VP8 or VP8L chunks are currently not supported");
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                byteOrderedDataOutputStream.writeInt(byteArrayOutputStream.size() + WEBP_SIGNATURE_2.length);
                byteOrderedDataOutputStream.write(WEBP_SIGNATURE_2);
                byteArrayOutputStream.writeTo(byteOrderedDataOutputStream);
                closeQuietly(byteArrayOutputStream);
            } catch (Exception e3) {
                e = e3;
                throw new IOException("Failed to save WebP file", e);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                closeQuietly(byteArrayOutputStream2);
                throw th;
            }
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, this, byteOrderedDataInputStream) == null) {
            HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
            ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
            if (exifAttribute != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                this.mThumbnailCompression = intValue;
                if (intValue != 1) {
                    if (intValue == 6) {
                        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                        return;
                    } else if (intValue != 7) {
                        return;
                    }
                }
                if (isSupportedDataType(hashMap)) {
                    handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                    return;
                }
                return;
            }
            this.mThumbnailCompression = 6;
            handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
        }
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void swapBasedOnImageSize(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65596, this, i2, i3) == null) {
            if (!this.mAttributes[i2].isEmpty() && !this.mAttributes[i3].isEmpty()) {
                ExifAttribute exifAttribute = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
                ExifAttribute exifAttribute2 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
                ExifAttribute exifAttribute3 = this.mAttributes[i3].get(TAG_IMAGE_LENGTH);
                ExifAttribute exifAttribute4 = this.mAttributes[i3].get(TAG_IMAGE_WIDTH);
                if (exifAttribute == null || exifAttribute2 == null) {
                    boolean z = DEBUG;
                    return;
                } else if (exifAttribute3 != null && exifAttribute4 != null) {
                    int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                    int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                    int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                    int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                    if (intValue >= intValue3 || intValue2 >= intValue4) {
                        return;
                    }
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                    return;
                } else {
                    boolean z2 = DEBUG;
                    return;
                }
            }
            boolean z3 = DEBUG;
        }
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65597, this, byteOrderedDataInputStream, i2) == null) {
            ExifAttribute exifAttribute = this.mAttributes[i2].get(TAG_DEFAULT_CROP_SIZE);
            ExifAttribute exifAttribute2 = this.mAttributes[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
            ExifAttribute exifAttribute5 = this.mAttributes[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
            if (exifAttribute == null) {
                if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
                    int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
                    int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
                    int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
                    int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
                    if (intValue2 <= intValue || intValue3 <= intValue4) {
                        return;
                    }
                    ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                    ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                    this.mAttributes[i2].put(TAG_IMAGE_LENGTH, createUShort3);
                    this.mAttributes[i2].put(TAG_IMAGE_WIDTH, createUShort4);
                    return;
                }
                retrieveJpegImageSize(byteOrderedDataInputStream, i2);
                return;
            }
            if (exifAttribute.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr != null && rationalArr.length == 2) {
                    createUShort = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
                } else {
                    String str = "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr);
                    return;
                }
            } else {
                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                if (iArr != null && iArr.length == 2) {
                    createUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
                } else {
                    String str2 = "Invalid crop size values. cropSize=" + Arrays.toString(iArr);
                    return;
                }
            }
            this.mAttributes[i2].put(TAG_IMAGE_WIDTH, createUShort);
            this.mAttributes[i2].put(TAG_IMAGE_LENGTH, createUShort2);
        }
    }

    private void validateImages() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            swapBasedOnImageSize(0, 5);
            swapBasedOnImageSize(0, 4);
            swapBasedOnImageSize(5, 4);
            ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
            ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
            if (exifAttribute != null && exifAttribute2 != null) {
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
            }
            if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
                HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                hashMapArr[4] = hashMapArr[5];
                hashMapArr[5] = new HashMap<>();
            }
            isThumbnail(this.mAttributes[4]);
        }
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, this, byteOrderedDataOutputStream)) == null) {
            ExifTag[][] exifTagArr = EXIF_TAGS;
            int[] iArr = new int[exifTagArr.length];
            int[] iArr2 = new int[exifTagArr.length];
            for (ExifTag exifTag : EXIF_POINTER_TAGS) {
                removeAttribute(exifTag.name);
            }
            removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
            removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
            for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                for (Object obj : this.mAttributes[i2].entrySet().toArray()) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (entry.getValue() == null) {
                        this.mAttributes[i2].remove(entry.getKey());
                    }
                }
            }
            if (!this.mAttributes[1].isEmpty()) {
                this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (!this.mAttributes[2].isEmpty()) {
                this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (!this.mAttributes[3].isEmpty()) {
                this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
            }
            if (this.mHasThumbnail) {
                this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0L, this.mExifByteOrder));
                this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
            }
            for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
                int i4 = 0;
                for (Map.Entry<String, ExifAttribute> entry2 : this.mAttributes[i3].entrySet()) {
                    int size = entry2.getValue().size();
                    if (size > 4) {
                        i4 += size;
                    }
                }
                iArr2[i3] = iArr2[i3] + i4;
            }
            int i5 = 8;
            for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
                if (!this.mAttributes[i6].isEmpty()) {
                    iArr[i6] = i5;
                    i5 += (this.mAttributes[i6].size() * 12) + 2 + 4 + iArr2[i6];
                }
            }
            if (this.mHasThumbnail) {
                this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(i5, this.mExifByteOrder));
                this.mThumbnailOffset = this.mExifOffset + i5;
                i5 += this.mThumbnailLength;
            }
            if (this.mMimeType == 4) {
                i5 += 8;
            }
            if (DEBUG) {
                for (int i7 = 0; i7 < EXIF_TAGS.length; i7++) {
                    String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(this.mAttributes[i7].size()), Integer.valueOf(iArr2[i7]), Integer.valueOf(i5));
                }
            }
            if (!this.mAttributes[1].isEmpty()) {
                this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
            }
            if (!this.mAttributes[2].isEmpty()) {
                this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(iArr[2], this.mExifByteOrder));
            }
            if (!this.mAttributes[3].isEmpty()) {
                this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(iArr[3], this.mExifByteOrder));
            }
            int i8 = this.mMimeType;
            if (i8 == 4) {
                byteOrderedDataOutputStream.writeUnsignedShort(i5);
                byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
            } else if (i8 == 13) {
                byteOrderedDataOutputStream.writeInt(i5);
                byteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
            } else if (i8 == 14) {
                byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
                byteOrderedDataOutputStream.writeInt(i5);
            }
            byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
            byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
            byteOrderedDataOutputStream.writeUnsignedShort(42);
            byteOrderedDataOutputStream.writeUnsignedInt(8L);
            for (int i9 = 0; i9 < EXIF_TAGS.length; i9++) {
                if (!this.mAttributes[i9].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i9].size());
                    int size2 = iArr[i9] + 2 + (this.mAttributes[i9].size() * 12) + 4;
                    for (Map.Entry<String, ExifAttribute> entry3 : this.mAttributes[i9].entrySet()) {
                        int i10 = sExifTagMapsForWriting[i9].get(entry3.getKey()).number;
                        ExifAttribute value = entry3.getValue();
                        int size3 = value.size();
                        byteOrderedDataOutputStream.writeUnsignedShort(i10);
                        byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                        byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                        if (size3 > 4) {
                            byteOrderedDataOutputStream.writeUnsignedInt(size2);
                            size2 += size3;
                        } else {
                            byteOrderedDataOutputStream.write(value.bytes);
                            if (size3 < 4) {
                                while (size3 < 4) {
                                    byteOrderedDataOutputStream.writeByte(0);
                                    size3++;
                                }
                            }
                        }
                    }
                    if (i9 == 0 && !this.mAttributes[4].isEmpty()) {
                        byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                    } else {
                        byteOrderedDataOutputStream.writeUnsignedInt(0L);
                    }
                    for (Map.Entry<String, ExifAttribute> entry4 : this.mAttributes[i9].entrySet()) {
                        byte[] bArr = entry4.getValue().bytes;
                        if (bArr.length > 4) {
                            byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                        }
                    }
                }
            }
            if (this.mHasThumbnail) {
                byteOrderedDataOutputStream.write(getThumbnailBytes());
            }
            if (this.mMimeType == 14 && i5 % 2 == 1) {
                byteOrderedDataOutputStream.writeByte(0);
            }
            byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
            return i5;
        }
        return invokeL.intValue;
    }

    public void flipHorizontally() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = 1;
            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                case 1:
                    i2 = 2;
                    break;
                case 2:
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 3;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                    i2 = 5;
                    break;
                case 7:
                    i2 = 8;
                    break;
                case 8:
                    i2 = 7;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i2));
        }
    }

    public void flipVertically() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = 1;
            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                    break;
                case 5:
                    i2 = 8;
                    break;
                case 6:
                    i2 = 7;
                    break;
                case 7:
                    i2 = 6;
                    break;
                case 8:
                    i2 = 5;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i2));
        }
    }

    public double getAltitude(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
            int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
            if (attributeDouble < 0.0d || attributeInt < 0) {
                return d2;
            }
            return attributeDouble * (attributeInt != 1 ? 1 : -1);
        }
        return invokeCommon.doubleValue;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                ExifAttribute exifAttribute = getExifAttribute(str);
                if (exifAttribute != null) {
                    if (!sTagSetForCompatibility.contains(str)) {
                        return exifAttribute.getStringValue(this.mExifByteOrder);
                    }
                    if (str.equals(TAG_GPS_TIMESTAMP)) {
                        int i2 = exifAttribute.format;
                        if (i2 != 5 && i2 != 10) {
                            String str2 = "GPS Timestamp format is not rational. format=" + exifAttribute.format;
                            return null;
                        }
                        Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                        if (rationalArr != null && rationalArr.length == 3) {
                            return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator))));
                        }
                        String str3 = "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr);
                        return null;
                    }
                    try {
                        return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                ExifAttribute exifAttribute = getExifAttribute(str);
                if (exifAttribute != null) {
                    return exifAttribute.bytes;
                }
                return null;
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return (byte[]) invokeL.objValue;
    }

    public double getAttributeDouble(@NonNull String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (str != null) {
                ExifAttribute exifAttribute = getExifAttribute(str);
                if (exifAttribute == null) {
                    return d2;
                }
                try {
                    return exifAttribute.getDoubleValue(this.mExifByteOrder);
                } catch (NumberFormatException unused) {
                    return d2;
                }
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return invokeCommon.doubleValue;
    }

    public int getAttributeInt(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            if (str != null) {
                ExifAttribute exifAttribute = getExifAttribute(str);
                if (exifAttribute == null) {
                    return i2;
                }
                try {
                    return exifAttribute.getIntValue(this.mExifByteOrder);
                } catch (NumberFormatException unused) {
                    return i2;
                }
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return invokeLI.intValue;
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str != null) {
                if (!this.mModified) {
                    ExifAttribute exifAttribute = getExifAttribute(str);
                    if (exifAttribute != null) {
                        return new long[]{exifAttribute.bytesOffset, exifAttribute.bytes.length};
                    }
                    return null;
                }
                throw new IllegalStateException("The underlying file has been modified since being parsed");
            }
            throw new NullPointerException("tag shouldn't be null");
        }
        return (long[]) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME)) : invokeV.longValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTimeDigitized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED)) : invokeV.longValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTimeOriginal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL)) : invokeV.longValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String attribute = getAttribute(TAG_GPS_DATESTAMP);
            String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
            if (attribute != null && attribute2 != null && (sNonZeroTimePattern.matcher(attribute).matches() || sNonZeroTimePattern.matcher(attribute2).matches())) {
                try {
                    Date parse = sFormatter.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fArr)) == null) {
            double[] latLong = getLatLong();
            if (latLong == null) {
                return false;
            }
            fArr[0] = (float) latLong[0];
            fArr[1] = (float) latLong[1];
            return true;
        }
        return invokeL.booleanValue;
    }

    public int getRotationDegrees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            switch (getAttributeInt(TAG_ORIENTATION, 1)) {
                case 3:
                case 4:
                    return 180;
                case 5:
                case 8:
                    return 270;
                case 6:
                case 7:
                    return 90;
                default:
                    return 0;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public byte[] getThumbnail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.mThumbnailCompression;
            if (i2 == 6 || i2 == 7) {
                return getThumbnailBytes();
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mHasThumbnail) {
                if (this.mThumbnailBytes == null) {
                    this.mThumbnailBytes = getThumbnailBytes();
                }
                int i2 = this.mThumbnailCompression;
                if (i2 == 6 || i2 == 7) {
                    return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
                }
                if (i2 == 1) {
                    int length = this.mThumbnailBytes.length / 3;
                    int[] iArr = new int[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        byte[] bArr = this.mThumbnailBytes;
                        int i4 = i3 * 3;
                        iArr[i3] = (bArr[i4] << 16) + 0 + (bArr[i4 + 1] << 8) + bArr[i4 + 2];
                    }
                    ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
                    ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
                    if (exifAttribute != null && exifAttribute2 != null) {
                        return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
                    }
                }
                return null;
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0065 A[Catch: all -> 0x0098, Exception -> 0x00b1, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x00b1, all -> 0x0098, blocks: (B:38:0x0065, B:41:0x0075, B:43:0x0081, B:48:0x008c, B:49:0x0091, B:50:0x0092, B:51:0x0097, B:55:0x009d, B:56:0x00a2), top: B:78:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d A[Catch: all -> 0x0098, Exception -> 0x00b1, TryCatch #5 {Exception -> 0x00b1, all -> 0x0098, blocks: (B:38:0x0065, B:41:0x0075, B:43:0x0081, B:48:0x008c, B:49:0x0091, B:50:0x0092, B:51:0x0097, B:55:0x009d, B:56:0x00a2), top: B:78:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getThumbnailBytes() {
        InterceptResult invokeV;
        Throwable th;
        FileDescriptor fileDescriptor;
        FileInputStream fileInputStream;
        Throwable th2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048593, this)) != null) {
            return (byte[]) invokeV.objValue;
        }
        InputStream inputStream = null;
        if (!this.mHasThumbnail) {
            return null;
        }
        byte[] bArr = this.mThumbnailBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
        } catch (Exception unused) {
            fileInputStream = null;
            fileDescriptor = null;
        } catch (Throwable th3) {
            th = th3;
            fileDescriptor = null;
        }
        try {
            if (this.mAssetInputStream != null) {
                fileInputStream = this.mAssetInputStream;
                try {
                    if (fileInputStream.markSupported()) {
                        fileInputStream.reset();
                    } else {
                        closeQuietly(fileInputStream);
                        return null;
                    }
                } catch (Exception unused2) {
                    fileDescriptor = null;
                    closeQuietly(fileInputStream);
                    if (fileDescriptor != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    inputStream = fileInputStream;
                    th = th4;
                    fileDescriptor = null;
                    closeQuietly(inputStream);
                    if (fileDescriptor != null) {
                    }
                    throw th;
                }
            } else if (this.mFilename != null) {
                fileInputStream = new FileInputStream(this.mFilename);
            } else {
                if (Build.VERSION.SDK_INT < 21 || this.mSeekableFileDescriptor == null) {
                    fileInputStream = null;
                    fileDescriptor = null;
                } else {
                    FileDescriptor dup = Os.dup(this.mSeekableFileDescriptor);
                    try {
                        Os.lseek(dup, 0L, OsConstants.SEEK_SET);
                        fileDescriptor = dup;
                        fileInputStream = new FileInputStream(dup);
                    } catch (Exception unused3) {
                        fileDescriptor = dup;
                        fileInputStream = null;
                        closeQuietly(fileInputStream);
                        if (fileDescriptor != null) {
                            closeFileDescriptor(fileDescriptor);
                        }
                        return null;
                    } catch (Throwable th5) {
                        th2 = th5;
                        fileDescriptor = dup;
                        th = th2;
                        closeQuietly(inputStream);
                        if (fileDescriptor != null) {
                            closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                }
                if (fileInputStream == null) {
                    if (fileInputStream.skip(this.mThumbnailOffset) == this.mThumbnailOffset) {
                        byte[] bArr2 = new byte[this.mThumbnailLength];
                        if (fileInputStream.read(bArr2) == this.mThumbnailLength) {
                            this.mThumbnailBytes = bArr2;
                            closeQuietly(fileInputStream);
                            if (fileDescriptor != null) {
                                closeFileDescriptor(fileDescriptor);
                            }
                            return bArr2;
                        }
                        throw new IOException("Corrupted image");
                    }
                    throw new IOException("Corrupted image");
                }
                throw new FileNotFoundException();
            }
            if (fileInputStream == null) {
            }
        } catch (Exception unused4) {
            closeQuietly(fileInputStream);
            if (fileDescriptor != null) {
            }
            return null;
        } catch (Throwable th6) {
            th2 = th6;
            inputStream = fileInputStream;
            th = th2;
            closeQuietly(inputStream);
            if (fileDescriptor != null) {
            }
            throw th;
        }
        fileDescriptor = null;
    }

    @Nullable
    public long[] getThumbnailRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!this.mModified) {
                if (this.mHasThumbnail) {
                    if (!this.mHasThumbnailStrips || this.mAreThumbnailStripsConsecutive) {
                        return new long[]{this.mThumbnailOffset, this.mThumbnailLength};
                    }
                    return null;
                }
                return null;
            }
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        return (long[]) invokeV.objValue;
    }

    public boolean hasAttribute(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? getExifAttribute(str) != null : invokeL.booleanValue;
    }

    public boolean hasThumbnail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mHasThumbnail : invokeV.booleanValue;
    }

    public boolean isFlipped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
        }
        return invokeV.booleanValue;
    }

    public boolean isThumbnailCompressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mHasThumbnail) {
                int i2 = this.mThumbnailCompression;
                return i2 == 6 || i2 == 7;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void resetOrientation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            setAttribute(TAG_ORIENTATION, Integer.toString(1));
        }
    }

    public void rotate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 % 90 == 0) {
                int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
                if (ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                    int indexOf = (ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                    r3 = ROTATION_ORDER.get(indexOf + (indexOf < 0 ? 4 : 0)).intValue();
                } else if (FLIPPED_ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (FLIPPED_ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                    r3 = FLIPPED_ROTATION_ORDER.get(indexOf2 + (indexOf2 < 0 ? 4 : 0)).intValue();
                }
                setAttribute(TAG_ORIENTATION, Integer.toString(r3));
                return;
            }
            throw new IllegalArgumentException("degree should be a multiple of 90");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00a0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x0166 */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(6:(2:18|(1:20)(2:74|75))(2:76|(1:102)(17:80|81|82|84|85|22|23|24|(1:26)(2:64|(1:69)(1:68))|27|28|29|31|32|(1:34)(2:37|(1:39)(2:40|(1:42)))|35|36))|31|32|(0)(0)|35|36)|23|24|(0)(0)|27|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0114, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0115, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0118, code lost:
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0119, code lost:
        r5 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be A[Catch: all -> 0x011c, Exception -> 0x011f, TryCatch #10 {Exception -> 0x011f, all -> 0x011c, blocks: (B:45:0x00b5, B:47:0x00be, B:54:0x00de, B:48:0x00c6, B:50:0x00ca, B:52:0x00ce), top: B:116:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[Catch: all -> 0x011c, Exception -> 0x011f, TryCatch #10 {Exception -> 0x011f, all -> 0x011c, blocks: (B:45:0x00b5, B:47:0x00be, B:54:0x00de, B:48:0x00c6, B:50:0x00ca, B:52:0x00ce), top: B:116:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed A[Catch: all -> 0x0110, Exception -> 0x0112, TryCatch #12 {Exception -> 0x0112, all -> 0x0110, blocks: (B:56:0x00e8, B:58:0x00ed, B:59:0x00f1, B:61:0x00f7, B:62:0x00fb, B:64:0x0101), top: B:113:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1 A[Catch: all -> 0x0110, Exception -> 0x0112, TryCatch #12 {Exception -> 0x0112, all -> 0x0110, blocks: (B:56:0x00e8, B:58:0x00ed, B:59:0x00f1, B:61:0x00f7, B:62:0x00fb, B:64:0x0101), top: B:113:0x00e8 }] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveAttributes() throws IOException {
        ?? r7;
        File file;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048601, this) != null) {
            return;
        }
        if (isSupportedFormatForSavingAttributes()) {
            if (this.mSeekableFileDescriptor == null && this.mFilename == null) {
                throw new IOException("ExifInterface does not support saving attributes for the current input.");
            }
            this.mModified = true;
            this.mThumbnailBytes = getThumbnail();
            InputStream inputStream = null;
            File file2 = this.mFilename != null ? new File(this.mFilename) : null;
            try {
                try {
                    try {
                        if (this.mFilename != null) {
                            file = new File(this.mFilename + ".tmp");
                            if (!file2.renameTo(file)) {
                                throw new IOException("Couldn't rename to " + file.getAbsolutePath());
                            }
                            fileInputStream = null;
                        } else if (Build.VERSION.SDK_INT >= 21 && this.mSeekableFileDescriptor != null) {
                            file = File.createTempFile(SevenZipUtils.FILE_NAME_TEMP, "tmp");
                            Os.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                            fileInputStream = new FileInputStream(this.mSeekableFileDescriptor);
                            try {
                                r7 = new FileOutputStream(file);
                            } catch (Exception e2) {
                                e = e2;
                                r7 = 0;
                            } catch (Throwable th) {
                                th = th;
                                r7 = 0;
                            }
                            try {
                                copy(fileInputStream, r7);
                                fileInputStream2 = r7;
                                closeQuietly(fileInputStream);
                                closeQuietly(fileInputStream2);
                                FileInputStream fileInputStream3 = new FileInputStream(file);
                                if (this.mFilename == null) {
                                    fileOutputStream = new FileOutputStream(this.mFilename);
                                } else if (Build.VERSION.SDK_INT < 21 || this.mSeekableFileDescriptor == null) {
                                    fileOutputStream = null;
                                } else {
                                    Os.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                    fileOutputStream = new FileOutputStream(this.mSeekableFileDescriptor);
                                }
                                bufferedInputStream = new BufferedInputStream(fileInputStream3);
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                if (this.mMimeType != 4) {
                                    saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                } else if (this.mMimeType == 13) {
                                    savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                } else if (this.mMimeType == 14) {
                                    saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                }
                                closeQuietly(bufferedInputStream);
                                closeQuietly(bufferedOutputStream);
                                file.delete();
                                this.mThumbnailBytes = null;
                                return;
                            } catch (Exception e3) {
                                e = e3;
                                inputStream = fileInputStream;
                                r7 = r7;
                                try {
                                    throw new IOException("Failed to copy original file to temp file", e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    closeQuietly(inputStream);
                                    closeQuietly(r7);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = fileInputStream;
                                closeQuietly(inputStream);
                                closeQuietly(r7);
                                throw th;
                            }
                        } else {
                            file = null;
                            fileInputStream = null;
                        }
                        if (this.mMimeType != 4) {
                        }
                        closeQuietly(bufferedInputStream);
                        closeQuietly(bufferedOutputStream);
                        file.delete();
                        this.mThumbnailBytes = null;
                        return;
                    } catch (Exception e4) {
                        e = e4;
                        inputStream = bufferedInputStream;
                        try {
                            if (this.mFilename != null && !file.renameTo(file2)) {
                                throw new IOException("Couldn't restore original file: " + file2.getAbsolutePath());
                            }
                            throw new IOException("Failed to save new file", e);
                        } catch (Throwable th4) {
                            th = th4;
                            closeQuietly(inputStream);
                            closeQuietly(bufferedOutputStream);
                            file.delete();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = bufferedInputStream;
                        closeQuietly(inputStream);
                        closeQuietly(bufferedOutputStream);
                        file.delete();
                        throw th;
                    }
                    FileInputStream fileInputStream32 = new FileInputStream(file);
                    if (this.mFilename == null) {
                    }
                    bufferedInputStream = new BufferedInputStream(fileInputStream32);
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e5) {
                    e = e5;
                    bufferedOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                }
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream);
                closeQuietly(fileInputStream2);
            } catch (Exception e6) {
                e = e6;
                r7 = 0;
            } catch (Throwable th7) {
                th = th7;
                r7 = 0;
            }
        } else {
            throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
    }

    public void setAltitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d2)}) == null) {
            String str = d2 >= 0.0d ? "0" : "1";
            setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d2)).toString());
            setAttribute(TAG_GPS_ALTITUDE_REF, str);
        }
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifTag exifTag;
        int i2;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) {
            String str3 = str;
            String str4 = str2;
            if (str3 != null) {
                if (TAG_ISO_SPEED_RATINGS.equals(str3)) {
                    boolean z = DEBUG;
                    str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
                }
                int i3 = 2;
                int i4 = 1;
                if (str4 != null && sTagSetForCompatibility.contains(str3)) {
                    if (str3.equals(TAG_GPS_TIMESTAMP)) {
                        if (!sGpsTimestampPattern.matcher(str4).find()) {
                            String str5 = "Invalid value for " + str3 + ZeusCrashHandler.NAME_SEPERATOR + str4;
                            return;
                        }
                        str4 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                    } else {
                        try {
                            str4 = new Rational(Double.parseDouble(str2)).toString();
                        } catch (NumberFormatException unused) {
                            String str6 = "Invalid value for " + str3 + ZeusCrashHandler.NAME_SEPERATOR + str4;
                            return;
                        }
                    }
                }
                int i5 = 0;
                while (i5 < EXIF_TAGS.length) {
                    if ((i5 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i5].get(str3)) != null) {
                        if (str4 == null) {
                            this.mAttributes[i5].remove(str3);
                        } else {
                            Pair<Integer, Integer> guessDataFormat = guessDataFormat(str4);
                            if (exifTag.primaryFormat != ((Integer) guessDataFormat.first).intValue() && exifTag.primaryFormat != ((Integer) guessDataFormat.second).intValue()) {
                                int i6 = exifTag.secondaryFormat;
                                if (i6 != -1 && (i6 == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                                    i2 = exifTag.secondaryFormat;
                                } else {
                                    int i7 = exifTag.primaryFormat;
                                    if (i7 != i4 && i7 != 7 && i7 != i3) {
                                        if (DEBUG) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Given tag (");
                                            sb.append(str3);
                                            sb.append(") value didn't match with one of expected formats: ");
                                            sb.append(IFD_FORMAT_NAMES[exifTag.primaryFormat]);
                                            sb.append(exifTag.secondaryFormat == -1 ? "" : StringUtil.ARRAY_ELEMENT_SEPARATOR + IFD_FORMAT_NAMES[exifTag.secondaryFormat]);
                                            sb.append(" (guess: ");
                                            sb.append(IFD_FORMAT_NAMES[((Integer) guessDataFormat.first).intValue()]);
                                            sb.append(((Integer) guessDataFormat.second).intValue() != -1 ? StringUtil.ARRAY_ELEMENT_SEPARATOR + IFD_FORMAT_NAMES[((Integer) guessDataFormat.second).intValue()] : "");
                                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
                                            sb.toString();
                                        }
                                    } else {
                                        i2 = exifTag.primaryFormat;
                                    }
                                }
                            } else {
                                i2 = exifTag.primaryFormat;
                            }
                            switch (i2) {
                                case 1:
                                    this.mAttributes[i5].put(str3, ExifAttribute.createByte(str4));
                                    continue;
                                case 2:
                                case 7:
                                    this.mAttributes[i5].put(str3, ExifAttribute.createString(str4));
                                    continue;
                                case 3:
                                    String[] split = str4.split(",", -1);
                                    int[] iArr = new int[split.length];
                                    for (int i8 = 0; i8 < split.length; i8++) {
                                        iArr[i8] = Integer.parseInt(split[i8]);
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                                    continue;
                                case 4:
                                    String[] split2 = str4.split(",", -1);
                                    long[] jArr = new long[split2.length];
                                    for (int i9 = 0; i9 < split2.length; i9++) {
                                        jArr[i9] = Long.parseLong(split2[i9]);
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                    continue;
                                case 5:
                                    String[] split3 = str4.split(",", -1);
                                    Rational[] rationalArr = new Rational[split3.length];
                                    for (int i10 = 0; i10 < split3.length; i10++) {
                                        String[] split4 = split3[i10].split("/", -1);
                                        rationalArr[i10] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                    continue;
                                case 6:
                                case 8:
                                case 11:
                                default:
                                    if (DEBUG) {
                                        String str7 = "Data format isn't one of expected formats: " + i2;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 9:
                                    String[] split5 = str4.split(",", -1);
                                    int[] iArr2 = new int[split5.length];
                                    for (int i11 = 0; i11 < split5.length; i11++) {
                                        iArr2[i11] = Integer.parseInt(split5[i11]);
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                                    continue;
                                case 10:
                                    String[] split6 = str4.split(",", -1);
                                    Rational[] rationalArr2 = new Rational[split6.length];
                                    int i12 = 0;
                                    while (i12 < split6.length) {
                                        String[] split7 = split6[i12].split("/", -1);
                                        rationalArr2[i12] = new Rational((long) Double.parseDouble(split7[0]), (long) Double.parseDouble(split7[i4]));
                                        i12++;
                                        i4 = 1;
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                                    continue;
                                case 12:
                                    String[] split8 = str4.split(",", -1);
                                    double[] dArr = new double[split8.length];
                                    for (int i13 = 0; i13 < split8.length; i13++) {
                                        dArr[i13] = Double.parseDouble(split8[i13]);
                                    }
                                    this.mAttributes[i5].put(str3, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                                    continue;
                            }
                        }
                    }
                    i5++;
                    i3 = 2;
                    i4 = 1;
                }
                return;
            }
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            setAttribute(TAG_DATETIME, sFormatter.format(new Date(j)));
            setAttribute(TAG_SUBSEC_TIME, Long.toString(j % 1000));
        }
    }

    public void setGpsInfo(Location location) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, location) == null) || location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = sFormatter.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, split[0]);
        setAttribute(TAG_GPS_TIMESTAMP, split[1]);
    }

    public void setLatLong(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            if (d2 >= -90.0d && d2 <= 90.0d && !Double.isNaN(d2)) {
                if (d3 >= -180.0d && d3 <= 180.0d && !Double.isNaN(d3)) {
                    setAttribute(TAG_GPS_LATITUDE_REF, d2 >= 0.0d ? "N" : LATITUDE_SOUTH);
                    setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d2)));
                    setAttribute(TAG_GPS_LONGITUDE_REF, d3 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
                    setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d3)));
                    return;
                }
                throw new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
            }
            throw new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, inputStream, outputStream, i2) == null) {
            byte[] bArr = new byte[8192];
            while (i2 > 0) {
                int min = Math.min(i2, 8192);
                int read = inputStream.read(bArr, 0, min);
                if (read == min) {
                    i2 -= read;
                    outputStream.write(bArr, 0, read);
                } else {
                    throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
                }
            }
        }
    }

    @Nullable
    public double[] getLatLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String attribute = getAttribute(TAG_GPS_LATITUDE);
            String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
            String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
            String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
            if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
                return null;
            }
            try {
                return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
            } catch (IllegalArgumentException unused) {
                String str = "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4);
                return null;
            }
        }
        return (double[]) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class ExifTag {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = -1;
        }

        public boolean isFormatCompatible(int i2) {
            InterceptResult invokeI;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                int i4 = this.primaryFormat;
                if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.secondaryFormat) == i2) {
                    return true;
                }
                if ((i4 == 4 || i3 == 4) && i2 == 3) {
                    return true;
                }
                if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i2 == 8) {
                    return true;
                }
                return (this.primaryFormat == 12 || this.secondaryFormat == 12) && i2 == 11;
            }
            return invokeI.booleanValue;
        }

        public ExifTag(String str, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = i4;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface(@NonNull FileDescriptor fileDescriptor) throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileDescriptor};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (fileDescriptor != null) {
            this.mAssetInputStream = null;
            this.mFilename = null;
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 21 && isSeekableFD(fileDescriptor)) {
                this.mSeekableFileDescriptor = fileDescriptor;
                try {
                    fileDescriptor = Os.dup(fileDescriptor);
                    z = true;
                } catch (Exception e2) {
                    throw new IOException("Failed to duplicate file descriptor", e2);
                }
            } else {
                this.mSeekableFileDescriptor = null;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    loadAttributes(fileInputStream);
                    closeQuietly(fileInputStream);
                    if (z) {
                        closeFileDescriptor(fileDescriptor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileInputStream);
                    if (z) {
                        closeFileDescriptor(fileDescriptor);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } else {
            throw new NullPointerException("fileDescriptor cannot be null");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExifInterface(@NonNull InputStream inputStream, int i2) throws IOException {
        this(inputStream, i2 == 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public ExifInterface(@NonNull InputStream inputStream, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (z) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (!isExifDataOnly(bufferedInputStream)) {
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
